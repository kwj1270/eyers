package net.iwinv.eyers1.config.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String user_name;
    private String user_nickname;
    private Role user_role;

    public SessionUser(User user) {
        if (user == null) {
        } else {
            this.user_name = user.getUser_name();
            this.user_nickname = user.getUser_nickname();
            this.user_role = user.getUser_role();
        }
    }
}
