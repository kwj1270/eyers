package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.freeboard.Freeboard;

@Getter
public class FreeboardsListResponseDto {

    private long freeboardSeq;
    private String freeboardTitle;
    private String freeboardName; // 작성자
    private String freeboardContent;
    private String freeboardDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    public FreeboardsListResponseDto(Freeboard entity){
        this.freeboardSeq = entity.getFreeboardSeq();
        this.freeboardTitle = entity.getFreeboardTitle();
        this.freeboardName = entity.getFreeboardName();
        this.freeboardContent = entity.getFreeboardContent();
        this.freeboardDate = entity.getFreeboardDate();
    }
}
