package net.iwinv.eyers.dto.board.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers.domain.user.board.comment.Comment;
import net.iwinv.eyers.domain.user.user.User;

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
