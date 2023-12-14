package org.arno.shortlink.admin.controller;

import lombok.RequiredArgsConstructor;
import org.arno.shortlink.admin.common.convention.result.Result;
import org.arno.shortlink.admin.common.convention.result.Results;
import org.arno.shortlink.admin.common.enums.UserErrorCodeEnum;
import org.arno.shortlink.admin.dto.response.UserResponseDTO;
import org.arno.shortlink.admin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserResponseDTO> getUserByUsername(@PathVariable("username") String username) {
        UserResponseDTO userResponseDTO = userService.getUserByUsername(username);
        if (userResponseDTO == null) {
            return new Result<UserResponseDTO>()
                    .setCode(UserErrorCodeEnum.USER_NULL.code())
                    .setMessage(UserErrorCodeEnum.USER_NULL.message());
        } else {
            return Results.success(userResponseDTO);
        }
    }
}
