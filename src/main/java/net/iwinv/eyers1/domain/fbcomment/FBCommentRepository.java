package net.iwinv.eyers1.domain.fbcomment;

import net.iwinv.eyers1.domain.freeboard.Freeboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// <CRUD메소드를 만들 대상(테이블), PK 자료형>
public interface FBCommentRepository extends JpaRepository<FBComment, Long> {

    @Query("SELECT fbc FROM FBComment fbc ORDER BY fbc.fbcommentSeq DESC")
    List<FBComment> findAllDesc();
}
