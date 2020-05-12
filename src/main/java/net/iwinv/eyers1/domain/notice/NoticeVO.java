package net.iwinv.eyers1.domain.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter // getter 메소드를 만든다.
@NoArgsConstructor // 생성자 의존성 주입
@Entity // DB 테이블로 사용되는 객체임을 나타낸다.
@Table(name = "Notice")
public class NoticeVO {

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long noticeSeq;
    @Column(nullable = false) // SQL == ....not null unique
    private String noticeTitle;
    @Column(nullable = false) // SQL == ....not null unique
    private String noticeName; // 작성자
    @Column(nullable = false) // SQL == ....not null unique
    private String noticeContent;
    @Column(nullable = false) // SQL == ....not null unique
    private String noticeDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    @Builder
    public NoticeVO(String noticeTitle,String noticeName ,String noticeContent, String noticeDate){
        this.noticeTitle = noticeTitle;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
    }

    public NoticeVO update(String noticeTitle, String noticeContent, String noticeDate){
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
        return this;
    }
}
