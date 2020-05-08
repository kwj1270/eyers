package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.notice.NoticeVO;

import java.time.LocalDateTime;

@Getter
public class NoticesListResponseDto {

    private Long notice_seq;
    private String notice_title;
    private Long notice_name;
    private String notice_content;
    private String notice_date;

    public NoticesListResponseDto(NoticeVO entity){
        this.notice_seq = entity.getNoticeSeq();
        this.notice_title = entity.getNotice_title();
        this.notice_name = entity.getNotice_name();
        this.notice_content = entity.getNotice_content();
        this.notice_date = entity.getNotice_date();
    }
}
