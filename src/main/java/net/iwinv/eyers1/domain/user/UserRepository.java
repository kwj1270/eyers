package net.iwinv.eyers1.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

                                                    // <CRUD메소드를 만들 대상(테이블), PK 자료형>
public interface UserRepository extends JpaRepository<User,Long> { // 별거 없어보이지만 DAO의 CRUD메소드를 자동 새성함 (우리눈에 안보임)
/*
    // DAO의 CRUD 기능을 알아서 만들어 준다.
*/
    // CRUD 외의 쿼리를 만들고 싶을때 사용
    @Query("SELECT u FROM User u WHERE u.user_id = :user_id AND u.user_pw = :user_pw")
    User login(@Param("user_id") String user_id, @Param("user_pw") String user_pw);
    // @Param으로 써져있으면 해당 값을 쿼리 문자열에 할당함
    // 즉, @Param("user_id") String user_id 의 값이 kwj1270일 경우
    // @Query("SELECT u FROM User u WHERE u.user_id = kwj1270 AND u.user_pw = :user_pw")
    // 이렇게 되는 것이다.

}
