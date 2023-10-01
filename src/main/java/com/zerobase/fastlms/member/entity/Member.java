package com.zerobase.fastlms.member.entity;

import com.zerobase.fastlms.history.entity.LoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member implements MemberCode {
    
    @Id
    private String userId;
    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;
    private LocalDateTime udtDt;//회원정보 수정일
    
    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey;
    
    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;
    
    private boolean adminYn;
    
    private String userStatus;//이용가능한상태, 정지상태
    
    
    private String zipcode;
    private String addr;
    private String addrDetail;

    @OneToMany(mappedBy = "member")
    private List<LoginHistory> loginHistories;
}