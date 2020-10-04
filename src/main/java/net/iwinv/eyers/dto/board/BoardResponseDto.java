package net.iwinv.eyers.dto.board;

import lombok.Getter;
import net.iwinv.eyers.domain.board.Board;
import net.iwinv.eyers.domain.board.BoardType;
import net.iwinv.eyers.domain.board.comment.Comment;
import net.iwinv.eyers.domain.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String subTitle;
    private String content;
    private BoardType boardType;
    private User user;
    private List<Comment> comments;
    private LocalDateTime modifiedDate;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.subTitle = entity.getSubTitle();
        this.content = entity.getContent();
        this.boardType = entity.getType();
        this.user = entity.getUser();
        this.comments = entity.getComments();
        this.modifiedDate = entity.getModifiedDate();
    }
}
