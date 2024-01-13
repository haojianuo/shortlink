package org.arno.shortlink.admin.dto.request;

import lombok.Data;

@Data
public class UserLoginRequestDTO {
    private String username;

    private String password;
}
