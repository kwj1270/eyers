package net.iwinv.eyers1.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers1.domain.BaseTimeEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
//public class User extends BaseTimeEntity {
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_seq;

    @Column(nullable = false, unique = true)
    private String user_id;

    @Column(nullable = false)
    private String user_pw;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false, unique = true)
    private String user_studentnumber;

    @Column(nullable = false, unique = true)
    private String user_nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role user_role;


    @Builder
    public User(String user_id, String user_pw, String user_name, String user_studentnumber, String user_nickname, Role user_role){
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_studentnumber = user_studentnumber;
        this.user_nickname = user_nickname;
        this.user_role = user_role;
    }

    //@Builder
    public User get(String user_id, String user_pw, String user_name, String user_studentnumber, String user_nickname, Role user_role){
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_studentnumber = user_studentnumber;
        this.user_nickname = user_nickname;
        this.user_role = user_role;
        return this;
    }

    public User update(String user_pw, String user_nickname){
        this.user_pw = user_pw;
        this.user_nickname = user_nickname;
        return this;
    }

}
