package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.notice.NoticeVO;

import java.time.LocalDateTime;

@Getter
public class NoticesListResponseDto {

    private long noticeSeq;
    private String noticeTitle;
    private String noticeName; // 작성자
    private String noticeContent;
    private String noticeDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    public NoticesListResponseDto(NoticeVO entity){
        this.noticeSeq = entity.getNoticeSeq();
        this.noticeTitle = entity.getNoticeTitle();
        this.noticeName = entity.getNoticeName();
        this.noticeContent = entity.getNoticeContent();
        this.noticeDate = entity.getNoticeDate();
    }
}
