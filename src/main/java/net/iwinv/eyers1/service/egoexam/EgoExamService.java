package net.iwinv.eyers1.service.egoexam;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.domain.egoexam.EgoExam;
import net.iwinv.eyers1.domain.egoexam.EgoExamRepository;
import net.iwinv.eyers1.web.dto.EgoExamResponseDto;
import net.iwinv.eyers1.web.dto.EgoExamSaveRequestDto;
import net.iwinv.eyers1.web.dto.EgoExamUpdateRequestDto;
import net.iwinv.eyers1.web.dto.EgoExamsListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EgoExamService {

    private final EgoExamRepository egoExamRepository;

    @Transactional(readOnly = true)
    public Page<EgoExamsListResponseDto> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(page, 10);
        return egoExamRepository.findAll(pageable).map(EgoExamsListResponseDto::new);
    }

    @Transactional
    public long save(EgoExamSaveRequestDto requestDto){
        return egoExamRepository.save(requestDto.toEntity()).getEgoexamSeq();
    }

    @Transactional // 유저 정보 삭제
    public EgoExamResponseDto findById(Long egoexamSeq) {
        EgoExam entity = egoExamRepository.findById(egoexamSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + egoexamSeq));
        return new EgoExamResponseDto(entity);
    }

    @Transactional  // 업데이트 하고 seq 값 반
    public Long update(Long egoexamSeq, EgoExamUpdateRequestDto requestDto) { // 바꿀 대상이랑 매개변수 받기 (spring 컨테이너를 통한 객체 자동 생성 및 주입)
        EgoExam egoexam = egoExamRepository.findById(egoexamSeq).orElseThrow(() -> // 람다식 사용 있으면 반환 없으면 던져라 (매개변수로 들어간 익명 객체)
                new IllegalArgumentException("해당 공지가 없습니다" + egoexamSeq)); //  없으면 null 안주고 에러 발생
        egoexam.update(requestDto.getEgoexamTitle(), requestDto.getEgoexamContent(),requestDto.getEgoexamFile(), requestDto.getEgoexamDate()); // update 객체를 이용한 update 진행
        return egoexamSeq;    // 에러가 없다면 pk를 보내 성공 여부 알려
    }

    @Transactional // 유저 정보 삭제
    public void delete(Long egoexamSeq) {
        EgoExam egoexam = egoExamRepository.findById(egoexamSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + egoexamSeq));
        egoExamRepository.delete(egoexam);
    }

}
