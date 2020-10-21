package net.iwinv.eyers.dto.user;

import lombok.Builder;
import net.iwinv.eyers.domain.user.user.User;
import net.iwinv.eyers.domain.user.user.enums.Role;
import net.iwinv.eyers.domain.user.user.enums.UserStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserSaveRequestDto {

    private String userId;
    private String password;
    private String name;
    private String studentId;
    private String nickName;
    private Role role;
    private UserStatus status;

    public UserSaveRequestDto(String userId, String password, String name, String studentId, String nickName){
        this(userId, password, name, studentId, nickName, Role.GUEST, UserStatus.ACTIVE);
    }

    @Builder
    public UserSaveRequestDto(String userId, String password, String name, String studentId, String nickName, Role role, UserStatus status){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
        this.nickName = nickName;
        this.role = role;
        this.status = status;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .userId(userId)
                .password(password)
                .studentId(studentId)
                .nickName(nickName)
                .role(role)
                .status(status)
                .build();
    }

    public UserSaveRequestDto encodingPassword(PasswordEncoder passwordEncoder){
        password = passwordEncoder.encode(password);
        return this;
    }

}
