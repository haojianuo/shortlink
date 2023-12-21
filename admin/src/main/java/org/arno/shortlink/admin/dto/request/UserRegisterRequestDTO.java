package org.arno.shortlink.admin.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequestDTO {
    private String username;

    private String password;

    private String realName;

    private String phone;

    private String mail;
}
