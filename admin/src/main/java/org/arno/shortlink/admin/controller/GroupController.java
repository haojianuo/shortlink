package org.arno.shortlink.admin.controller;

import lombok.RequiredArgsConstructor;
import org.arno.shortlink.admin.common.convention.result.Result;
import org.arno.shortlink.admin.common.convention.result.Results;
import org.arno.shortlink.admin.dto.request.ShortLinkGroupSaveRequestDTO;
import org.arno.shortlink.admin.dto.response.ShortLinkGroupResponseDTO;
import org.arno.shortlink.admin.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/api/short-link/v1/group")
    public Result<Void> saveGroup(@RequestBody ShortLinkGroupSaveRequestDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    @GetMapping("/api/short-link/v1/group")
    public Result<List<ShortLinkGroupResponseDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

}
