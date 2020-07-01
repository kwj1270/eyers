package net.iwinv.eyers1.service.freeboard;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.domain.freeboard.FreeboardRepository;
import net.iwinv.eyers1.domain.freeboard.Freeboard;
import net.iwinv.eyers1.web.dto.FreeboardResponseDto;
import net.iwinv.eyers1.web.dto.FreeboardSaveRequestDto;
import net.iwinv.eyers1.web.dto.FreeboardUpdateRequestDto;
import net.iwinv.eyers1.web.dto.FreeboardsListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FreeboardService {
    private final FreeboardRepository freeboardRepository;

    @Transactional(readOnly = true)
    public Page<FreeboardsListResponseDto> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(page, 10);
        return freeboardRepository.findAll(pageable).map(FreeboardsListResponseDto::new);
    }

    @Transactional
    public long save(FreeboardSaveRequestDto requestDto){
        return freeboardRepository.save(requestDto.toEntity()).getFreeboardSeq();
    }

    @Transactional // 유저 정보 삭제
    public FreeboardResponseDto findById(Long freeboardSeq) {
        Freeboard entity = freeboardRepository.findById(freeboardSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + freeboardSeq));
        return new FreeboardResponseDto(entity);
    }

    @Transactional  // 업데이트 하고 seq 값 반
    public Long update(Long freeboardSeq, FreeboardUpdateRequestDto requestDto) { // 바꿀 대상이랑 매개변수 받기 (spring 컨테이너를 통한 객체 자동 생성 및 주입)
        Freeboard freeboard = freeboardRepository.findById(freeboardSeq).orElseThrow(() -> // 람다식 사용 있으면 반환 없으면 던져라 (매개변수로 들어간 익명 객체)
                new IllegalArgumentException("해당 공지가 없습니다" + freeboardSeq)); //  없으면 null 안주고 에러 발생
        freeboard.update(requestDto.getFreeboardTitle(), requestDto.getFreeboardContent(), requestDto.getFreeboardDate()); // update 객체를 이용한 update 진행
        return freeboardSeq;    // 에러가 없다면 pk를 보내 성공 여부 알려
    }

    @Transactional // 유저 정보 삭제
    public void delete(Long freeboardSeq) {
        Freeboard freeboard = freeboardRepository.findById(freeboardSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + freeboardSeq));
        freeboardRepository.delete(freeboard);
    }

}
