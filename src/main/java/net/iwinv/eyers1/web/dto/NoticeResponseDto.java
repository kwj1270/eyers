package net.iwinv.eyers1.web.dto;

import net.iwinv.eyers1.domain.notice.NoticeVO;
import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 데이터베이스로부터 하나의 데이터를 가져올 때 사용하는 클래스
public class NoticeResponseDto {
    private long notice_seq;
    private String notice_title;
    private long notice_name; // 작성자
    private String notice_content;
    private String notice_date; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    public NoticeResponseDto(NoticeVO entity){
        this.notice_seq = entity.getNoticeSeq();
        this.notice_title = entity.getNotice_title();
        this.notice_name = entity.getNotice_name();
        this.notice_content = entity.getNotice_content();
        this.notice_date = entity.getNotice_date();
    }
}
