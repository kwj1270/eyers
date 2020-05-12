package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwinv.eyers1.domain.freeboard.Freeboard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class FreeboardSaveRequestDto {

    private String freeboardTitle;
    private String freeboardName; // 작성자
    private String freeboardContent;
    private String freeboardDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    @Builder
    public FreeboardSaveRequestDto(String freeboardTitle, String freeboardName, String freeboardContent, String freeboardDate){
        this.freeboardTitle = freeboardTitle;
        this.freeboardName = freeboardName;
        this.freeboardContent = freeboardContent;
        this.freeboardDate = freeboardDate;
    }

    public Freeboard toEntity(){
        return Freeboard.builder()
                .freeboardTitle(this.freeboardTitle)
                .freeboardName(this.freeboardName)
                .freeboardContent(this.freeboardContent)
                .freeboardDate(this.freeboardDate)
                .build();
    }
}
