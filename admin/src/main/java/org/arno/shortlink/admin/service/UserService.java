package org.arno.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.arno.shortlink.admin.dao.entity.UserDO;
import org.arno.shortlink.admin.dto.request.UserRegisterRequestDTO;
import org.arno.shortlink.admin.dto.response.UserResponseDTO;

public interface UserService extends IService<UserDO> {
    UserResponseDTO getUserByUsername(String username);

    Boolean hasUsername(String username);

    void register(UserRegisterRequestDTO requestParam);
}
