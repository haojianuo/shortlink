package org.arno.shortlink.admin.common.database;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

/**
 * 基础DO
 */
public class BaseDO {
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
