package net.iwinv.eyers.dto.board.comment;

import lombok.Getter;
import net.iwinv.eyers.domain.user.board.comment.Comment;
import net.iwinv.eyers.domain.user.user.User;

@Getter
public class CommentListResponseDto {

    private Long id;
    private String content;
    private User user;

    public CommentListResponseDto(Comment entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.user = entity.getUser();
    }

}
