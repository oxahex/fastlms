package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.history.service.LoginHistoryService;
import com.zerobase.fastlms.util.RequestUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final LoginHistoryService loginHistoryService;

    public UserAuthenticationSuccessHandler(LoginHistoryService loginHistoryService) {
        this.loginHistoryService = loginHistoryService;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    )
            throws IOException, ServletException
    {
        System.out.println("username: " + request.getParameter("username"));
        System.out.println("time: " + LocalDateTime.now());
        System.out.println("user-agent: " + request.getHeader("User-Agent"));

        System.out.println("ip: " + RequestUtils.getClientIp(request));


        System.out.println(authentication.getPrincipal().toString());
        loginHistoryService.addLoginHistory(
                request.getParameter("username"),
                LocalDateTime.now(),
                RequestUtils.getUserAgent(request),
                RequestUtils.getClientIp(request)
        );

        super.onAuthenticationSuccess(request, response, authentication);
    }
}