package net.iwinv.eyers1.web.dto;

import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;

// 데이터베이스로부터 하나의 데이터를 가져올 때 사용하는 클래스
public class UserResponseDto {

    private Long userSeq;
    private String userId;
    private String userPw;
    private String userName;
    private String userStudentnumber;
    private String userNickname;
    private Role userRole;

    public UserResponseDto(User entity){
        this.userSeq = entity.getUserSeq();
        this.userId = entity.getUserId();
        this.userPw = entity.getUserPw();
        this.userName = entity.getUserName();
        this.userStudentnumber = entity.getUserStudentnumber();
        this.userNickname = entity.getUserNickname();
        this.userRole = entity.getUserRole();
    }
}
