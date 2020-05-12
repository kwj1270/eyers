package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwinv.eyers1.domain.notice.NoticeVO;

@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveRequestDto {


    private String noticeTitle;
    private String noticeName; // 작성자
    private String noticeContent;
    private String noticeDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다


    @Builder
    public NoticeSaveRequestDto(String noticeTitle, String noticeName, String noticeContent, String noticeDate){
        this.noticeTitle = noticeTitle;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
    }

    public NoticeVO toEntity(){
        return NoticeVO.builder()
                .noticeTitle(this.noticeTitle)
                .noticeName(this.noticeName)
                .noticeContent(this.noticeContent)
                .noticeDate(this.noticeDate)
                .build();
    }
}
