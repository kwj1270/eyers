package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// User에서 업데이트시 필요한 데이터만 모아놓은 클래스
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

}
