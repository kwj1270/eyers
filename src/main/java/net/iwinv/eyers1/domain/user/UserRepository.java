package net.iwinv.eyers1.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// <CRUD메소드를 만들 대상(테이블), PK 자료형>
public interface UserRepository extends JpaRepository<User, Long> { // 별거 없어보이지만 DAO의 CRUD메소드를 자동 새성함 (우리눈에 안보임)
    /*
        // DAO의 CRUD 기능을 알아서 만들어 준다.
    */
    // CRUD 외의 쿼리를 만들고 싶을때 사용
    @Query("SELECT u FROM User u WHERE u.userId = :userId AND u.userPw = :userPw")
    User login(@Param("userId") String userId, @Param("userPw") String userPw);
    // @Param으로 써져있으면 해당 값을 쿼리 문자열에 할당함
    // 즉, @Param("userId") String userId 의 값이 kwj1270일 경우
    // @Query("SELECT u FROM User u WHERE u.userId = kwj1270 AND u.userPw = :userPw")
    // 이렇게 되는 것이다.


    @Query("SELECT u FROM User u WHERE u.userId = :userId")
    User idCheck(@Param("userId") String userId);

    @Query("SELECT u FROM User u WHERE u.userStudentnumber = :userStudentnumber")
    User studentnumberCheck(@Param("userStudentnumber") String userStudentnumber);

    @Query("SELECT u FROM User u WHERE u.userNickname = :userNickname")
    User nicknameCheck(@Param("userNickname") String userNickname);

    @Query("SELECT userId FROM User u WHERE u.userName = :userName AND u.userStudentnumber = :userStudentnumber")
    String findId(@Param("userName") String userName, @Param("userStudentnumber") String userStudentnumber);

    @Query("SELECT userPw FROM User u WHERE u.userId = :userId AND u.userName = :userName AND u.userStudentnumber = :userStudentnumber")
    String findPassword(@Param("userId")String userId, @Param("userName") String userName, @Param("userStudentnumber") String userStudentnumber);

}
