package org.arno.shortlink.admin.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDTO {
    private Long id;

    private String username;

    private String realName;

    private String phone;

    private String mail;

}
