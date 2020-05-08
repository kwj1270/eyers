package net.iwinv.eyers1.domain.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// <CRUD메소드를 만들 대상(테이블), PK 자료형>
public interface NoticeRepository extends JpaRepository<NoticeVO, Long> {

    @Query("SELECT n FROM NoticeVO n ORDER BY n.noticeSeq DESC")
    List<NoticeVO> findAllDesc();
}
