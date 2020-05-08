package net.iwinv.eyers1.service.notice;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.domain.notice.NoticeRepository;
import net.iwinv.eyers1.domain.notice.NoticeVO;
import net.iwinv.eyers1.util.PageRequest;
import net.iwinv.eyers1.web.dto.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    // pageable 의 page 인덱스는 0부터 시작 한다.
    // 하지만 주로 게시판에서는 1부터 시작하기에 사용자가보려는 페이지에 -1 처리를 해준 것 이다.

    @Transactional
    public long save(NoticeSaveRequestDto requestDto){
       return noticeRepository.save(requestDto.toEntity()).getNoticeSeq();
    }

    @Transactional // 유저 정보 삭제
    public NoticeResponseDto findById(Long noticeSeq) {
       NoticeVO entity = noticeRepository.findById(noticeSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + noticeSeq));
        return new NoticeResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<NoticesListResponseDto> findAllDesc(@PageableDefault PageRequest pageable){ // page 랑 size 넘겨주기
        List<NoticesListResponseDto> list = noticeRepository.findAll(pageable.of())
                .stream()
                .map(NoticesListResponseDto::new)
                .collect(Collectors.toList());

        list.forEach(s -> System.out.println(s.getNoticeSeq()));

        return noticeRepository.findAll(pageable.of())
                .stream()
                .map(NoticesListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional  // 업데이트 하고 seq 값 반
    public Long update(Long noticeSeq, NoticeUpdateRequestDto requestDto) { // 바꿀 대상이랑 매개변수 받기 (spring 컨테이너를 통한 객체 자동 생성 및 주입)
        NoticeVO notice = noticeRepository.findById(noticeSeq).orElseThrow(() -> // 람다식 사용 있으면 반환 없으면 던져라 (매개변수로 들어간 익명 객체)
                new IllegalArgumentException("해당 공지가 없습니다" + noticeSeq)); //  없으면 null 안주고 에러 발생
        notice.update(requestDto.getNoticeTitle(), requestDto.getNoticeContent(), requestDto.getNoticeDate()); // update 객체를 이용한 update 진행
        return noticeSeq;    // 에러가 없다면 pk를 보내 성공 여부 알려
    }

    @Transactional // 유저 정보 삭제
    public void delete(Long noticeSeq) {
        NoticeVO notice = noticeRepository.findById(noticeSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + noticeSeq));
        noticeRepository.delete(notice);
    }

}
