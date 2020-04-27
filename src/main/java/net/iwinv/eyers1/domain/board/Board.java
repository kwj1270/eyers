package net.iwinv.eyers1.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long board_seq;
    @Column(nullable = false) // SQL == ....not null unique
    private String board_title;
    @Column(nullable = false, unique = true) // SQL == ....not null unique
    private long board_writer;
    @Column(nullable = false) // SQL == ....not null unique
    private String board_content;
    @Column(nullable = false) // SQL == ....not null unique
    private Date board_createdate;
    @Column() // SQL == ....not null unique
    private Date board_updatedate;

    @Builder // 생성자 위에 @Builder가 붙었다 이는 매개변수의 순서를 맞추지 않더라도 값을 할당받게 해준다.
    public Board(long board_seq, String board_title, long board_writer, String board_content, Date board_createdate, Date board_updatedate){
        this.board_seq = board_seq;
        this.board_title = board_title;
        this.board_writer = board_writer;
        this.board_content = board_content;
        this.board_createdate = board_createdate;
        this.board_updatedate = board_updatedate;
    }

    public Board update(String board_title, String board_content, Date board_updatedate){
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_updatedate = board_updatedate;
        return this;
    }
}
