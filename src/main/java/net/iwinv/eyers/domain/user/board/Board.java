package net.iwinv.eyers.domain.user.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers.domain.user.BaseTimeEntity;
import net.iwinv.eyers.domain.user.board.comment.Comment;
import net.iwinv.eyers.domain.user.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="BOARD")
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "BOARD_TITLE", length = 500, nullable = false)
    private String title;

    @Column(name = "BOARD_SUBTITLE", length = 500, nullable = false)
    private String subTitle;

    @Column(name = "BOARD_CONTENT", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "BOARD_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardType type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "BOARD_ID")
    private List<Comment> comments = new ArrayList<>();

    public Board(String title, String subTitle, String content, BoardType boardType) {
        this(title, subTitle, content, boardType, null, null);
    }

    public Board(String title, String subTitle, String content, BoardType boardType, User user) {
        this(title, subTitle, content, boardType, user, null);
    }

    @Builder
    public Board(String title, String subTitle, String content, BoardType type, User user, List<Comment> comments) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.user = user;
    }

    public Board update(String title, String subTitle, String content){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        return this;
    }

}
