package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.egoexam.EgoExam;

@Getter
public class EgoExamsListResponseDto {

    private long egoexamSeq;
    private String egoexamTitle;
    private String egoexamName; // 작성자
    private String egoexamContent;
    private long egoexamFile;
    private String egoexamDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    public EgoExamsListResponseDto(EgoExam entity){
        this.egoexamSeq = entity.getEgoexamSeq();
        this.egoexamTitle = entity.getEgoexamTitle();
        this.egoexamName = entity.getEgoexamName();
        this.egoexamContent = entity.getEgoexamContent();
        this.egoexamFile = entity.getEgoexamFile();
        this.egoexamDate = entity.getEgoexamDate();
    }
}
