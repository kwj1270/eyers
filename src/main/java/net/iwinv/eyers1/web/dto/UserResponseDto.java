package net.iwinv.eyers1.web.dto;

import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;

// 데이터베이스로부터 하나의 데이터를 가져올 때 사용하는 클래스
public class UserResponseDto {

    private Long user_seq;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_studentnumber;
    private String user_nickname;
    private Role user_role;

    public UserResponseDto(User entity){
        this.user_seq = entity.getUser_seq();
        this.user_id = entity.getUser_id();
        this.user_pw = entity.getUser_pw();
        this.user_name = entity.getUser_name();
        this.user_studentnumber = entity.getUser_studentnumber();
        this.user_nickname = entity.getUser_nickname();
        this.user_role = entity.getUser_role();
    }
}
