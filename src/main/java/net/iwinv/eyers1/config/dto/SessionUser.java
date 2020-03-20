package net.iwinv.eyers1.config.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;

import java.io.Serializable;


// 로그인 후 홈페이지에서 사용될 필요한 정보만 모아 Session 에 저장할 User 부분 클래스
@Getter // getter 메소드 자동 생성해준다.   -> getUser_name(){return user_name}
public class SessionUser implements Serializable {

    private String user_name;
    private String user_nickname;
    private Role user_role;

    public SessionUser(User user) {
            this.user_name = user.getUser_name();
            this.user_nickname = user.getUser_nickname();
            this.user_role = user.getUser_role();
    }
    // User 객체에서 필요한 정보만 받아서 저장하기 위한 것
}
