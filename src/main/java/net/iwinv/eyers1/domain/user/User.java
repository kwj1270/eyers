package net.iwinv.eyers1.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // getter 메소드를 만든다.
@NoArgsConstructor // 생성자 의존성 주입
@Entity // DB 테이블로 사용되는 객체임을 나타낸다.
//public class User extends BaseTimeEntity {
public class User{

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private Long userSeq;

    @Column(nullable = false, unique = true) // SQL == ....not null unique
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String userStudentnumber;

    @Column(nullable = false, unique = true)
    private String userNickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role userRole;
    // enum에서 USER("user", "일반 사용자") -> User 사용시 key:"user" value:"일반사용자"인 '객체'가 된다
    // 데이터베이스에서는 저런 객체는 값을 못넣으니 앞에 User만 가지고 디비값으로 넣는다.

    @Builder // 생성자 위에 @Builder가 붙었다 이는 매개변수의 순서를 맞추지 않더라도 값을 할당받게 해준다.
    public User(String userId, String userPw, String userName, String userStudentnumber, String userNickname, Role userRole){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userStudentnumber = userStudentnumber;
        this.userNickname = userNickname;
        this.userRole = userRole;
    } // 즉 user_id , user_pw .... 순서에 맞지 않게 값을 넣어도 된다는 뜻
    // 다시 말하면 첫번째 매개변수에 user_studentnumber를 넣어도 알아서 자리에 맞게 찾아감

    public User update(String userPw, String userNickname){ // 값 변경을 쉽게 하기 위한 메소드
        this.userPw = userPw;
        this.userNickname = userNickname;
        return this;
    }

}
