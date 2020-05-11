package net.iwinv.eyers1.domain.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// <CRUD메소드를 만들 대상(테이블), PK 자료형>
public interface FreeboardRepository extends JpaRepository<Freeboard, Long> {

    @Query("SELECT b FROM Freeboard b ORDER BY b.freeboardSeq DESC")
    List<Freeboard> findAllDesc();
}
