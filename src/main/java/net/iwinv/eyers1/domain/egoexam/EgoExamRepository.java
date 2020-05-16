package net.iwinv.eyers1.domain.egoexam;

import net.iwinv.eyers1.domain.fbcomment.FBComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// <CRUD메소드를 만들 대상(테이블), PK 자료형>
public interface EgoExamRepository extends JpaRepository<EgoExam, Long> {
}
