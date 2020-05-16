package net.iwinv.eyers1.domain.egoexam;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class EgoExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long egoexamSeq;

    @Column(nullable = false) // SQL == ....not null
    private String egoexamTitle;

    @Column(nullable = false) // SQL == ....not null
    private String egoexamName;

    @Column(nullable = false) // SQL == ....not null
    private String egoexamContent;

    @Column(nullable = false, unique = true) // SQL == ....not null
    private long egoexamFile;

    @Column(nullable = false) // SQL == ....not null
    private String egoexamDate;

    @Builder
    public EgoExam(long egoexamSeq, String egoexamTitle, String egoexamName, String egoexamContent, long egoexamFile, String egoexamDate) {
        this.egoexamSeq = egoexamSeq;
        this.egoexamTitle = egoexamTitle;
        this.egoexamName = egoexamName;
        this.egoexamContent = egoexamContent;
        this.egoexamFile = egoexamFile;
        this.egoexamDate = egoexamDate;
    }

    public EgoExam update (String egoexamTitle, String egoexamContent, long egoexamFile, String egoexamDate) {
        this.egoexamTitle = egoexamTitle;
        this.egoexamContent = egoexamContent;
        this.egoexamFile = egoexamFile;
        this.egoexamDate = egoexamDate;
        return this;
    }
}
