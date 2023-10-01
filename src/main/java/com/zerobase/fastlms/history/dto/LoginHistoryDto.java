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
    private LocalDateTime loginDate;
    private String userAgent;
    private String userIp;

    public static LoginHistoryDto of(LoginHistory loginHistory) {
        return LoginHistoryDto.builder()
                .loginDate(loginHistory.getLoginDate())
                .userAgent(loginHistory.getUserAgent())
                .userIp(loginHistory.getUserIp()).build();
    }
}