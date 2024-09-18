package org.arno.shortlink.admin.controller;

import lombok.RequiredArgsConstructor;
import org.arno.shortlink.admin.common.convention.result.Result;
import org.arno.shortlink.admin.remote.ShortLinkActualRemoteService;
import org.arno.shortlink.admin.remote.ShortLinkRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * URL 标题控制层
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {
    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    /**
     * 根据URL获取对应网站的标题
     */
    @GetMapping("/api/short-link/admin/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return shortLinkActualRemoteService.getTitleByUrl(url);
    }
}
