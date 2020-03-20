package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto { // 업데이트시 필요한 정보를 모아놓은 Dto

    private String user_pw;
    private String user_nickname;

    @Builder
    public UserUpdateRequestDto(String user_pw, String user_nickname){
        this.user_pw = user_pw;
        this.user_nickname = user_nickname;
    }

}
