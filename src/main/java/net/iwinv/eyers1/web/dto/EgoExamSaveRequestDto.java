package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwinv.eyers1.domain.egoexam.EgoExam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class EgoExamSaveRequestDto {

    private String egoexamTitle;
    private String egoexamName; // 작성자
    private String egoexamContent;
    private long egoexamFile;
    private String egoexamDate; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    @Builder
    public EgoExamSaveRequestDto(String egoexamTitle, String egoexamName, String egoexamContent,long egoexamFile, String egoexamDate){
        this.egoexamTitle = egoexamTitle;
        this.egoexamName = egoexamName;
        this.egoexamContent = egoexamContent;
        this.egoexamFile = egoexamFile;
        this.egoexamDate = egoexamDate;
    }

    public EgoExam toEntity(){
        return EgoExam.builder()
                .egoexamTitle(this.egoexamTitle)
                .egoexamName(this.egoexamName)
                .egoexamContent(this.egoexamContent)
                .egoexamFile(this.egoexamFile)
                .egoexamDate(this.egoexamDate)
                .build();
    }
}
