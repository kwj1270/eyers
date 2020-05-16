package net.iwinv.eyers1.domain.fbcomment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class FBComment {

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long fbcommentSeq; // PK
    @Column(nullable = false) // SQL == ....not null unique
    private String fbcommentFreeboard; // FK
    @Column(nullable = false) // SQL == ....not null unique
    private String fbcommentName; // FK
    @Column(nullable = false) // SQL == ....not null
    private String fbcommentContent; // 내용


    @Builder // 생성자 위에 @Builder가 붙었다 이는 매개변수의 순서를 맞추지 않더라도 값을 할당받게 해준다.
    public FBComment(long fbcommentSeq, String fbcommentFreeboard, String fbcommentName, String fbcommentContent){
        this.fbcommentSeq = fbcommentSeq;
        this.fbcommentFreeboard = fbcommentFreeboard;
        this.fbcommentName = fbcommentName;
        this.fbcommentContent = fbcommentContent;
    }

    public FBComment update(String fbcommentContent){
        this.fbcommentContent = fbcommentContent;
        return this;
    }
}
