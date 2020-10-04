package net.iwinv.eyers.dto.board.comment;

import lombok.Getter;
import net.iwinv.eyers.domain.board.Board;
import net.iwinv.eyers.domain.board.BoardType;
import net.iwinv.eyers.domain.board.comment.Comment;
import net.iwinv.eyers.domain.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CommentResponseDto {

    private Long id;
    private String content;
    private User user;
    private LocalDateTime modifiedDate;


    public CommentResponseDto(Comment entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.user = entity.getUser();
        this.modifiedDate = entity.getModifiedDate();
    }

}
