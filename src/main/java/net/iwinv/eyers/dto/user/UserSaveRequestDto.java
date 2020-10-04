package net.iwinv.eyers.dto.user;

import lombok.Builder;
import net.iwinv.eyers.domain.user.User;
import net.iwinv.eyers.domain.user.enums.Role;
import net.iwinv.eyers.domain.user.enums.UserStatus;

public class UserSaveRequestDto {

    private String name;
    private String userId;
    private String password;
    private final Role role = Role.USER;
    private final UserStatus status = UserStatus.ACTIVE;

    @Builder
    public UserSaveRequestDto(String name, String userId, String password, String email, String picture){
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .userId(userId)
                .password(password)
                .role(role)
                .status(status)
                .build();
    }
}
