package org.arno.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.arno.shortlink.project.common.convention.result.Result;
import org.arno.shortlink.project.common.convention.result.Results;
import org.arno.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.arno.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.arno.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.arno.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import org.arno.shortlink.project.service.ShortLinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri") String shortUri, ServletRequest request, ServletResponse response) {
        shortLinkService.restoreUrl(shortUri, request, response);
    }


    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }

    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

    @GetMapping("/api/short-link/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupCount(@RequestParam List<String> requestParam) {
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }

    @PostMapping("/api/short-link/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
    }

}
