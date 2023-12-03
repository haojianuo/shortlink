package org.arno.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.arno.shortlink.admin.dao.entity.UserDO;
import org.arno.shortlink.admin.dto.response.UserResponseDTO;

public interface UserService extends IService<UserDO> {
    UserResponseDTO getUserByUsername(String username);
}
