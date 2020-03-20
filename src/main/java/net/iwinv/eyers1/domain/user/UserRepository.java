package net.iwinv.eyers1.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    // DAO의 CRUD 기능을 알아서 만들어 준다.
    @Query("SELECT u FROM User u WHERE u.user_id = :user_id AND u.user_pw = :user_pw")
    User login(@Param("user_id") String user_id, @Param("user_pw") String user_pw);

}
