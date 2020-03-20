package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto { // 저장할 때 필요한 정보를 모아놓은 Dto

    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_studentnumber;
    private String user_nickname;
    private Role user_role;

    @Builder
    public UserSaveRequestDto(String user_id, String user_pw, String user_name, String user_studentnumber, String user_nickname, Role user_role){
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_studentnumber = user_studentnumber;
        this.user_nickname = user_nickname;
        this.user_role = user_role;
    }

    public User toEntity(){
        return User.builder()
                .user_id(user_id)
                .user_pw(user_pw)
                .user_name(user_name)
                .user_studentnumber(user_studentnumber)
                .user_nickname(user_nickname)
                .user_role(user_role)
                .build();
    }
}
