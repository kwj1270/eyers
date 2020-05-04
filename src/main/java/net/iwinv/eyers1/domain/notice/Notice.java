package net.iwinv.eyers1.domain.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Notice {

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long notice_seq;
    @Column(nullable = false) // SQL == ....not null unique
    private String notice_title;
    @Column(nullable = false, unique = true) // SQL == ....not null unique
    private long notice_name; // 작성자
    @Column(nullable = false) // SQL == ....not null unique
    private String notice_content;
    @Column(nullable = false) // SQL == ....not null unique
    private String notice_date; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다
}
