package org.arno.shortlink.project.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.arno.shortlink.project.common.convention.result.Result;
import org.arno.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkCreateRespDTO;

/**
 * 自定义流控策略
 * 公众号：马丁玩编程，回复：加群，添加马哥微信（备注：link）获取项目资料
 */
public class CustomBlockHandler {

    public static Result<ShortLinkCreateRespDTO> createShortLinkBlockHandlerMethod(ShortLinkCreateReqDTO requestParam, BlockException exception) {
        return new Result<ShortLinkCreateRespDTO>().setCode("B100000").setMessage("当前访问网站人数过多，请稍后再试...");
    }
}
