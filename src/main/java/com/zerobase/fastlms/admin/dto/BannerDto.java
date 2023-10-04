package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class BannerDto {

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

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .alterText(banner.getAlterText())
                .targetUrl(banner.getTargetUrl())
                .openBlankYn(banner.getOpenBlankYn())
                .sortOrder(banner.getSortOrder())
                .frontShowYn(banner.getFrontShowYn())
                .regDt(banner.getRegDt())
                .fileName(banner.getFileName())
                .urlFileName(banner.getUrlFileName())
                .build();
    }
}
