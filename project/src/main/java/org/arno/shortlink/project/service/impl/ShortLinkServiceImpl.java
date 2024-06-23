package org.arno.shortlink.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arno.shortlink.project.common.convention.exception.ServiceException;
import org.arno.shortlink.project.dao.entity.ShortLinkDO;
import org.arno.shortlink.project.dao.mapper.ShortLinkMapper;
import org.arno.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.arno.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import org.arno.shortlink.project.service.ShortLinkService;
import org.arno.shortlink.project.toolkit.HashUtil;
import org.redisson.api.RBloomFilter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {
    private final RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter;
    private final ShortLinkMapper shortLinkMapper;


    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {
        String shortLinkSuffix = generateSuffix(requestParam);
        String fullShortUrl = requestParam.getDomain() + "/" + shortLinkSuffix;
        ShortLinkDO shortLinkDO = ShortLinkDO.builder()
                .domain(requestParam.getDomain())
                .originUrl(requestParam.getOriginUrl())
                .shortUri(shortLinkSuffix)
                .fullShortUrl(fullShortUrl)
                .gid(requestParam.getGid())
                .createType(requestParam.getCreateType())
                .enableStatus(0)
                .describe(requestParam.getDescribe())
                .validDateType(requestParam.getValidDateType())
                .validDate(requestParam.getValidDate())
                .build();
        try {
            baseMapper.insert(shortLinkDO);
        } catch (DuplicateKeyException ex) {
            LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                    .eq(ShortLinkDO::getFullShortUrl, fullShortUrl);
            ShortLinkDO hasShortLinkDO = baseMapper.selectOne(queryWrapper);
            if (hasShortLinkDO != null) {
                log.warn("短链接{}已存在，重试生成短链接", fullShortUrl);
                throw new ServiceException("短链接已存在");
            }
        }
        shortUriCreateCachePenetrationBloomFilter.add(shortLinkSuffix);
        return ShortLinkCreateRespDTO.builder()
                .originUrl(requestParam.getOriginUrl())
                .fullShortUrl(shortLinkDO.getFullShortUrl())
                .gid(shortLinkDO.getGid())
                .build();
    }

    @Override
    public IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam) {
        LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getGid())
                .eq(ShortLinkDO::getEnableStatus, 0)
                .eq(ShortLinkDO::getDelFlag, 0)
                .orderByDesc(ShortLinkDO::getCreateTime);
        IPage<ShortLinkDO> resultPage = baseMapper.selectPage(requestParam, queryWrapper);
        return resultPage.convert(each -> BeanUtil.toBean(each, ShortLinkPageRespDTO.class));
    }

    @Override
    public List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam) {
        QueryWrapper<ShortLinkDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("gid", requestParam)
                .eq("enable_status", 0)
                .eq("del_flag", 0)
                .groupBy("gid")
                .select("gid as gid", "count(*) as count");
        // 手动映射字段名
        List<ShortLinkGroupCountQueryRespDTO> result = new ArrayList<>();
        for (Map<String, Object> map : shortLinkMapper.selectMaps(queryWrapper)) {
            ShortLinkGroupCountQueryRespDTO dto = new ShortLinkGroupCountQueryRespDTO();
            dto.setGid((String) map.get("gid"));
            dto.setShortLinkCount(((Long) map.get("count")).intValue()); // 处理 count 字段为 Long 类型的情况
            result.add(dto);
        }

        return result;

    }

    private String generateSuffix(ShortLinkCreateReqDTO requestParam) {
        int customerGenerateCount = 0;
        String shortUri;
        while (true) {
            if (customerGenerateCount > 10) {
                log.error("生成短链接失败，重试次数超过10次");
                throw new ServiceException("生成短链接失败，重试次数超过10次");
            }
            String originUrl = requestParam.getOriginUrl();
            originUrl = originUrl + System.currentTimeMillis();
            shortUri = HashUtil.hashToBase62(originUrl);
            if (!shortUriCreateCachePenetrationBloomFilter.contains(requestParam.getDomain() + "/" + shortUri)) {
                break;
            }
            customerGenerateCount++;
        }
        return shortUri;

    }
}
