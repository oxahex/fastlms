package com.zerobase.fastlms.member.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "login_history")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_member_id")
    private Member member;

    private LocalDateTime loginDate;
    private String userAgent;
    private String userIp;
}