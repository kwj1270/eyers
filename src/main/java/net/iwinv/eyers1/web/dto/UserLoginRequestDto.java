package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginRequestDto {

    private String user_id;
    private String user_pw;

    @Builder
    public UserLoginRequestDto(String user_id, String user_pw){
        this.user_id = user_id;
        this.user_pw = user_pw;
    }

}
