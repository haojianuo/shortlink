package org.arno.shortlink.admin.remote.dto.resp;

import lombok.Data;

/**
 * 短链接分组查询响应
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组下短链接数量
     */
    private Integer shortLinkCount;
}