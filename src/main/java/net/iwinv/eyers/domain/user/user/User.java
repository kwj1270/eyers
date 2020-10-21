package net.iwinv.eyers.domain.user.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers.domain.user.BaseTimeEntity;
import net.iwinv.eyers.domain.user.user.enums.Role;
import net.iwinv.eyers.domain.user.user.enums.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "USER")
@Entity
public class User extends BaseTimeEntity implements UserDetails { //implements Serializable

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(getRoleKey()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

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

    public User encodingPassword(PasswordEncoder passwordEncoder){
        password = passwordEncoder.encode(password);
        return this;
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


    private boolean isActive(){
        return this.status.equals(UserStatus.ACTIVE);
    }

}
