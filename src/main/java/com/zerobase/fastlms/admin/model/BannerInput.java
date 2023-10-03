package com.zerobase.fastlms.admin.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BannerInput {

    private Long id;

    private String bannerName;               // 배너 이름

    private String alterText;
    private String targetUrl;
    private Boolean openBlankYn;
    private Integer sortOrder;
    private Boolean frontShowYn;

    private LocalDateTime regDt;

    private String fileName;
    private String urlFileName;

}
