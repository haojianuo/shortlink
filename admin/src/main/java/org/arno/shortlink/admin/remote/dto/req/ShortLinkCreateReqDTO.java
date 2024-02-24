package org.arno.shortlink.admin.remote.dto.req;

import lombok.Data;

import java.util.Date;

@Data
public class ShortLinkCreateReqDTO {

    /**
     * 域名
     */
    private String domain;


    /**
     * 完整原始链接
     */
    private String originUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 0 接口创建，1 控制台创建
     */
    private int createType;

    /**
     * 0永久有效，1不是永久有效
     */
    private int validDateType;

    /**
     * 有效期
     */
    private Date validDate;

    /**
     * 描述
     */
    private String describe;

}
