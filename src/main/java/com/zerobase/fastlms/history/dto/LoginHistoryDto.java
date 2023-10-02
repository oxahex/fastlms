package com.zerobase.fastlms.history.dto;

import com.zerobase.fastlms.history.entity.LoginHistory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginHistoryDto {

    private Long id;
    private LocalDateTime loginDt;
    private String userAgent;
    private String userIp;

    public static LoginHistoryDto of(LoginHistory loginHistory) {
        return LoginHistoryDto.builder()
                .id(loginHistory.getId())
                .loginDt(loginHistory.getLoginDt())
                .userAgent(loginHistory.getUserAgent())
                .userIp(loginHistory.getUserIp()).build();
    }
}