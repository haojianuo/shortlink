package org.arno.shortlink.admin.dto.response;

import lombok.Data;

@Data
public class UserActualResponseDTO {
    private Long id;
    private String username;
    private String realName;
    private String phone;
    private String mail;
}
