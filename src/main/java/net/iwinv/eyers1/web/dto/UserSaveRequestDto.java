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

    private String userId;
    private String userPw;
    private String userName;
    private String userStudentnumber;
    private String userNickname;
    private Role userRole;

    @Builder
    public UserSaveRequestDto(String userId, String userPw, String userName, String userStudentnumber, String userNickname, Role userRole){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userStudentnumber = userStudentnumber;
        this.userNickname = userNickname;
        this.userRole = userRole;
    }

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userStudentnumber(userStudentnumber)
                .userNickname(userNickname)
                .userRole(userRole)
                .build();
    }
}
