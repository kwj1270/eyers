package net.iwinv.eyers.dto.board.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers.domain.board.Board;
import net.iwinv.eyers.domain.board.BoardType;
import net.iwinv.eyers.domain.board.comment.Comment;
import net.iwinv.eyers.domain.user.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private String content;
    private User user;

    @Builder
    public CommentSaveRequestDto(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .user(user)
                .build();
    }

}
