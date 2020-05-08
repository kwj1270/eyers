package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwinv.eyers1.domain.notice.NoticeVO;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveRequestDto {

    private String notice_title;
    private long notice_name; // 작성자
    private String notice_content;
    private String notice_date; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    @Builder
    public NoticeSaveRequestDto(String notice_title, Long notice_name, String notice_content, String notice_date){
        this.notice_title = notice_title;
        this.notice_name = notice_name;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
    }

    public NoticeVO toEntity(){
        return NoticeVO.builder()
                .notice_title(this.notice_title)
                .notice_name(this.notice_name)
                .notice_content(this.notice_content)
                .notice_date(this.notice_date)
                .build();
    }
}
