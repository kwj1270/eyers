package net.iwinv.eyers1.domain.fbcomment;

import net.iwinv.eyers1.domain.freeboard.Freeboard;
import net.iwinv.eyers1.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// <CRUD메소드를 만들 대상(테이블), PK 자료형>
public interface FBCommentRepository extends JpaRepository<FBComment, Long> {

    @Query("SELECT fbc FROM FBComment fbc ORDER BY fbc.fbcommentSeq DESC")
    List<FBComment> findAllDesc();

    @Query("SELECT fbc FROM FBComment fbc WHERE fbc.fbcommentFreeboard = :fbcommentFreeboard ORDER BY fbc.fbcommentSeq DESC")
    List<FBComment> findByFreeboardDesc(@Param("fbcommentFreeboard") long fbcommentFreeboard);

    @Query("SELECT fbc FROM FBComment fbc WHERE fbc.fbcommentFreeboard = :fbcommentFreeboard ORDER BY fbc.fbcommentSeq ASC")
    List<FBComment> findByFreeboardAsc(@Param("fbcommentFreeboard") long fbcommentFreeboard);

    @Query("SELECT u FROM User u WHERE u.userId = :userId AND u.userPw = :userPw")
    User login(@Param("userId") String userId, @Param("userPw") String userPw);
}
