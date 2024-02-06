package org.arno.shortlink.project.dto.resp;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateRespDTO {
    /**
     * 分组信息
     */
    private String gid;

    /**
     * 完整原始链接
     */
    private String originUrl;

    /**
     * 完整短链接
     */
    private String fullShortUrl;


}

