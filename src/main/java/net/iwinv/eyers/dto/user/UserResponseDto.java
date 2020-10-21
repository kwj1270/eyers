package net.iwinv.eyers.dto.user;

import lombok.Getter;
import net.iwinv.eyers.domain.user.user.User;
import net.iwinv.eyers.domain.user.user.enums.UserStatus;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private String userId;
    private String name;
    private UserStatus status;
    private LocalDateTime createdDate;

    public UserResponseDto(User entity) {
        this.userId = entity.getUserId();
        this.name = entity.getName();
        this.status = entity.getStatus();
        this.createdDate = entity.getCreatedDate();
    }

}