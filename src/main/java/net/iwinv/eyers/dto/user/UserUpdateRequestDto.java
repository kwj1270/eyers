package net.iwinv.eyers.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String name;
    private String password;
    private String nickName;
    @Builder
    public UserUpdateRequestDto(String name, String userId, String password, String nickName){
        this.name = name;
        this.password = password;
        this.nickName = nickName;
    }

}
