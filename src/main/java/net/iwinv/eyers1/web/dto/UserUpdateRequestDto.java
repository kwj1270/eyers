package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers1.domain.user.User;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String user_pw;
    private String user_nickname;

    @Builder
    public UserUpdateRequestDto(String user_pw, String user_nickname){
        this.user_pw = user_pw;
        this.user_nickname = user_nickname;
    }

    public User toEntity(){
        return User.builder()
                .user_pw(user_pw)
                .user_nickname(user_nickname)
                .build();
    }


}
