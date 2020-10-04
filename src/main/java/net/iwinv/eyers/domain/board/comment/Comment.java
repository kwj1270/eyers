package net.iwinv.eyers.domain.board.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers.domain.BaseTimeEntity;
import net.iwinv.eyers.domain.user.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "COMMENT")
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private long id;

    @Column(name = "COMMENT_CONTENT", length = 200, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;


    @Builder
    public Comment(String content, User user){
        this.content = content;
        this.user = user;
    }

    public Comment update(String content){
        this.content = content;
        return this;
    }

}
