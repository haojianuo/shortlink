package org.arno.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.arno.shortlink.project.dao.entity.ShortLinkDO;
import org.arno.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.arno.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.arno.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShortLinkService extends IService<ShortLinkDO> {
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);
}
