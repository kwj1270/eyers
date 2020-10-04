package net.iwinv.eyers.dto.user;

import net.iwinv.eyers.domain.user.User;
import net.iwinv.eyers.domain.user.enums.Role;
import net.iwinv.eyers.domain.user.enums.UserStatus;

import java.time.LocalDateTime;

public class UserListResponseDto {

    private String name;
    private String userId;
    private Role role;
    private UserStatus userStatus;
    private LocalDateTime modifiedDate;

    public UserListResponseDto(User user){
        this.name = user.getName();
        this.userId = user.getUserId();
        this.role = user.getRole();
        this.userStatus = user.getStatus();
        this.modifiedDate = user.getModifiedDate();
    }

}

