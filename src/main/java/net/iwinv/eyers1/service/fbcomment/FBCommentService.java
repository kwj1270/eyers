package net.iwinv.eyers1.service.fbcomment;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.domain.fbcomment.FBComment;
import net.iwinv.eyers1.domain.fbcomment.FBCommentRepository;
import net.iwinv.eyers1.web.dto.FBCommentResponseDto;
import net.iwinv.eyers1.web.dto.FBCommentSaveRequestDto;
import net.iwinv.eyers1.web.dto.FBCommentUpdateRequestDto;
import net.iwinv.eyers1.web.dto.FBCommentsListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FBCommentService {
    private final FBCommentRepository fbcommentRepository;

    @Transactional(readOnly = true)
    public Page<FBCommentsListResponseDto> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(page, 10);
        return fbcommentRepository.findAll(pageable).map(FBCommentsListResponseDto::new);
    }
    @Transactional(readOnly = true)
    public List<FBCommentsListResponseDto> findByFreeboardDesc(String fbcommentFreeboard) {
        return fbcommentRepository.findByFreeboardDesc(fbcommentFreeboard)
                .stream()
                .map(FBCommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public long save(FBCommentSaveRequestDto requestDto){
        return fbcommentRepository.save(requestDto.toEntity()).getFbcommentSeq();
    }

    @Transactional // 유저 정보 삭제
    public FBCommentResponseDto findById(Long fbcommentSeq) {
        FBComment entity = fbcommentRepository.findById(fbcommentSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + fbcommentSeq));
        return new FBCommentResponseDto(entity);
    }

    @Transactional  // 업데이트 하고 seq 값 반
    public Long update(Long fbcommentSeq, FBCommentUpdateRequestDto requestDto) { // 바꿀 대상이랑 매개변수 받기 (spring 컨테이너를 통한 객체 자동 생성 및 주입)
        FBComment fbcomment = fbcommentRepository.findById(fbcommentSeq).orElseThrow(() -> // 람다식 사용 있으면 반환 없으면 던져라 (매개변수로 들어간 익명 객체)
                new IllegalArgumentException("해당 공지가 없습니다" + fbcommentSeq)); //  없으면 null 안주고 에러 발생
        fbcomment.update(requestDto.getFbcommentContent()); // update 객체를 이용한 update 진행
        return fbcommentSeq;    // 에러가 없다면 pk를 보내 성공 여부 알려
    }

    @Transactional // 유저 정보 삭제
    public void delete(Long fbcommentSeq) {
        FBComment fbcomment = fbcommentRepository.findById(fbcommentSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + fbcommentSeq));
        fbcommentRepository.delete(fbcomment);
    }

}
