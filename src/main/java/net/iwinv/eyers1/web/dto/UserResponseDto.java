package net.iwinv.eyers1.web.dto;

import net.iwinv.eyers1.domain.user.User;

import javax.persistence.Column;

public class UserResponseDto {

    private Long user_seq;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_studentnumber;
    private String user_nickname;

    public UserResponseDto(User entity){
        this.user_seq = entity.getUser_seq();
        this.user_id = entity.getUser_id();
        this.user_pw = entity.getUser_pw();
        this.user_name = entity.getUser_name();
        this.user_studentnumber = entity.getUser_studentnumber();
        this.user_nickname = entity.getUser_nickname();
    }
}