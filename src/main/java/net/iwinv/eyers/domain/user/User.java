package net.iwinv.eyers.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers.domain.BaseTimeEntity;
import net.iwinv.eyers.domain.user.enums.Role;
import net.iwinv.eyers.domain.user.enums.UserStatus;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "USER")
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_USER_ID", nullable = false, unique = true)
    private String userId;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_STUDENT_ID", nullable = false, unique = true)
    private String studentId;

    @Column(name = "USER_NICKNAME", nullable = false, unique = true)
    private String nickName;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_STATUS", nullable = false)
    private UserStatus status;

    @Builder
    public User(String userId, String password, String name, String studentId, String nickName, Role role, UserStatus status){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
        this.nickName = nickName;
        this.role = role;
        this.status = status;
    }

    public void update(String name, String password, String nickName){ // 영속성 컨텍스트 이용하여 변경하
        this.password = name;
        this.password = password;
        this.nickName = nickName;
    }

    public User setInactive() {
        status = UserStatus.INACTIVE;
        return this;
    }

    public User setActive() {
        status = UserStatus.ACTIVE;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }


}
