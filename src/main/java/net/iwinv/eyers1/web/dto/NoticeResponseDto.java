package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.notice.NoticeVO;
import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 데이터베이스로부터 하나의 데이터를 가져올 때 사용하는 클래스
@Getter
public class NoticeResponseDto {

    private long noticeSeq;
    private String noticeTitle;
    private long noticeName; // 작성자
    private String noticeContent;
    private String noticeDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    public NoticeResponseDto(NoticeVO entity){
        this.noticeSeq = entity.getNoticeSeq();
        this.noticeTitle = entity.getNoticeTitle();
        this.noticeName = entity.getNoticeName();
        this.noticeContent = entity.getNoticeContent();
        this.noticeDate = entity.getNoticeDate();
    }
}
