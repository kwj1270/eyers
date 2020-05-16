package net.iwinv.eyers1.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long memberSeq;

    @Column(nullable = false) // SQL == ....not null unique
    private String memberName;

    @Column(nullable = false, unique = true) // SQL == ....not null unique
    private String memberStudentnumber;

    @Column(nullable = false, unique = true) // SQL == ....not null unique
    private String memberImage;

    @Builder
    public Member(String memberName, String memberStudentnumber, String memberImage){
        this.memberName = memberName;
        this.memberStudentnumber = memberStudentnumber;
        this.memberImage = memberImage;
    }

    public Member update(String memberName, String memberStudentnumber, String memberImage){
        this.memberName = memberName;
        this.memberStudentnumber = memberStudentnumber;
        this.memberImage = memberImage;
        return this;
    }

}
