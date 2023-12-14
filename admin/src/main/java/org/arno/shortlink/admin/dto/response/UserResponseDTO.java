package org.arno.shortlink.admin.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.arno.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;

@Data
public class UserResponseDTO {
    private Long id;

    private String username;

    private String realName;

    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    private String mail;

}
