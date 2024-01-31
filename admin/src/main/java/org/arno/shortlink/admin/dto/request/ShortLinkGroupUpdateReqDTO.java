package org.arno.shortlink.admin.dto.request;

import lombok.Data;

@Data
public class ShortLinkGroupUpdateReqDTO {
    private String gid;
    /**
     * 分组名
     */
    private String name;
}
