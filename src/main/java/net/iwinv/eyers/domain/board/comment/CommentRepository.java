package net.iwinv.eyers.domain.board.comment;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c ORDER BY c.createdDate DESC")
    List<Comment> findAllDesc();

    @Query("SELECT c FROM Comment c ORDER BY c.createdDate DESC")
    List<Comment> findAllDesc(Pageable pageable);

}
