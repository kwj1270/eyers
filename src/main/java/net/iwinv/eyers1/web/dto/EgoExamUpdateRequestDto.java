package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// User에서 업데이트시 필요한 데이터만 모아놓은 클래스
@Getter
@NoArgsConstructor
public class EgoExamUpdateRequestDto {

    private String egoexamTitle;
    private String egoexamContent;
    private long egoexamFile;
    private String egoexamDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    @Builder
    public EgoExamUpdateRequestDto(String egoexamTitle, String egoexamContent, long egoexamFile, String egoexamDate){
        this.egoexamTitle = egoexamTitle;
        this.egoexamContent = egoexamContent;
        this.egoexamFile = egoexamFile;
        this.egoexamDate = egoexamDate;
    }

}
