package org.arno.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.arno.shortlink.admin.common.convention.result.Result;
import org.arno.shortlink.admin.common.convention.result.Results;
import org.arno.shortlink.admin.dto.request.UserRegisterRequestDTO;
import org.arno.shortlink.admin.dto.response.UserActualResponseDTO;
import org.arno.shortlink.admin.dto.response.UserResponseDTO;
import org.arno.shortlink.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserResponseDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名获取脱敏用户信息
     */
    @GetMapping("/api/short-link/v1/actual/user/{username}")
    public Result<UserActualResponseDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualResponseDTO.class));
    }

    /**
     * 根据用户名判断用户是否存在
     */
    @GetMapping("/api/short-link/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 注册用户
     */
    @PostMapping("/api/short-link/v1/user/register")
    public Result<Void> register(@RequestBody UserRegisterRequestDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }
}
