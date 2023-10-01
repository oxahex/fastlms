package com.zerobase.fastlms.history.service;

import com.zerobase.fastlms.history.repository.LoginHistoryRepository;
import com.zerobase.fastlms.history.dto.LoginHistoryDto;
import com.zerobase.fastlms.history.entity.LoginHistory;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class LoginHistoryService {
    private final MemberRepository memberRepository;
    private final LoginHistoryRepository loginHistoryRepository;


    public LoginHistoryDto saveLoginHistory(
            String username,
            LocalDateTime loginDt,
            String userAgent,
            String userIp
    ) {

        Member member = memberRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));

        LoginHistory loginHistory = LoginHistory.builder()
                .member(member)
                .loginDate(loginDt)
                .userAgent(userAgent)
                .userIp(userIp).build();



        // 로그인 히스토리 저장 후 반환
        return LoginHistoryDto.of(loginHistoryRepository.save(loginHistory));
    }
}