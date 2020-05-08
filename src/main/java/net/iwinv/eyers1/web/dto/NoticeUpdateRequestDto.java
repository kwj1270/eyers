package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// User에서 업데이트시 필요한 데이터만 모아놓은 클래스
@Getter
@NoArgsConstructor
public class NoticeUpdateRequestDto {

    private String notice_title;
    private String notice_content;
    private String notice_date;

    @Builder
    public NoticeUpdateRequestDto(String notice_title, String notice_content, String notice_date){
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
    }

}
