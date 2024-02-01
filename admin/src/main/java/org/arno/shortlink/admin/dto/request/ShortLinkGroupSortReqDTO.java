package org.arno.shortlink.admin.dto.request;

import lombok.Data;

@Data
public class ShortLinkGroupSortReqDTO {
    private String gid;
    private Integer sortOrder;
}
