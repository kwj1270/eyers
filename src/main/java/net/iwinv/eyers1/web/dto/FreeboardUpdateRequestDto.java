package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// User에서 업데이트시 필요한 데이터만 모아놓은 클래스
@Getter
@NoArgsConstructor
public class FreeboardUpdateRequestDto {

    private String freeboardTitle;
    private String freeboardContent;
    private String freeboardDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    @Builder
    public FreeboardUpdateRequestDto(String freeboardTitle, String freeboardContent, String freeboardDate){
        this.freeboardTitle = freeboardTitle;
        this.freeboardContent = freeboardContent;
        this.freeboardDate = freeboardDate;
    }

}
