package org.arno.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.arno.shortlink.admin.common.convention.result.Result;
import org.arno.shortlink.admin.remote.ShortLinkRemoteService;
import org.arno.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.arno.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.arno.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import org.arno.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortLinkController {
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){
    };
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {

        return shortLinkRemoteService.createShortLink(requestParam);
    }
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }

}
