package com.zerobase.fastlms.admin.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bannerName;               // 배너 이름

    private String alterText;
    private String targetUrl;
    private Boolean openBlankYn;
    private Integer sortOrder;
    private Boolean frontShowYn;

    private LocalDateTime regDt;        // 등록일

    private String fileName;            // 서버가 관리하는 파일 이름
    private String urlFileName;             // 파일 주소
}
