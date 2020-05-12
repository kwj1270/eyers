package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.freeboard.Freeboard;

// 데이터베이스로부터 하나의 데이터를 가져올 때 사용하는 클래스
@Getter
public class FreeboardResponseDto {

    private long freeboardSeq;
    private String freeboardTitle;
    private String freeboardName; // 작성자
    private String freeboardContent;
    private String freeboardDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    public FreeboardResponseDto(Freeboard entity){
        this.freeboardSeq = entity.getFreeboardSeq();
        this.freeboardTitle = entity.getFreeboardTitle();
        this.freeboardName = entity.getFreeboardName();
        this.freeboardContent = entity.getFreeboardContent();
        this.freeboardDate = entity.getFreeboardDate();
    }
}
