package net.iwinv.eyers.config.dto;

import lombok.Getter;
import net.iwinv.eyers.domain.user.user.User;
import net.iwinv.eyers.domain.user.user.enums.Role;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String userId;
    private String userName;
    private String userNickname;
    private Role userRole;

    public SessionUser(User user) {
            this.userId = user.getUserId();
            this.userName = user.getName();
            this.userNickname = user.getNickName();
            this.userRole = user.getRole();
    }

    public boolean checkAdmin(){
        return userRole.getKey().equals("ADMIN");
    }
}
