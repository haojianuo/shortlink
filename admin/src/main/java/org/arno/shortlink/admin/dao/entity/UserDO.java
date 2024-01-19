package org.arno.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.arno.shortlink.admin.common.database.BaseDO;

import java.util.Date;
@Data
@TableName("t_user")
public class UserDO extends BaseDO {
    private Long id;

    private String username;

    private String password;

    private String realName;

    private String phone;

    private String mail;

    private Long deletionTime;

}