package net.iwinv.eyers1.domain.freeboard;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Getter
@NoArgsConstructor
@Entity
public class Freeboard {

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long freeboardSeq;
    @Column(nullable = false) // SQL == ....not null unique
    private String freeboardTitle;
    @Column(nullable = false, unique = true) // SQL == ....not null unique
    private long freeboardName;
    @Column(nullable = false) // SQL == ....not null
    private String freeboardContent;
    @Column(nullable = false) // SQL == ....not null
    private String freeboardDate;

    @Builder // 생성자 위에 @Builder가 붙었다 이는 매개변수의 순서를 맞추지 않더라도 값을 할당받게 해준다.
    public Freeboard(long freeboardSeq, String freeboardTitle, long freeboardName, String freeboardContent, String freeboardDate){
        this.freeboardSeq = freeboardSeq;
        this.freeboardTitle = freeboardTitle;
        this.freeboardName = freeboardName;
        this.freeboardContent = freeboardContent;
        this.freeboardDate = freeboardDate;
    }

    public Freeboard update(String freeboardTitle, String freeboardContent, String freeboardDate){
        this.freeboardTitle = freeboardTitle;
        this.freeboardContent = freeboardContent;
        this.freeboardDate = freeboardDate;
        return this;
    }
}
