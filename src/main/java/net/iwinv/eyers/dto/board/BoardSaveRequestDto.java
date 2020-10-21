package net.iwinv.eyers.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.iwinv.eyers.domain.user.board.Board;
import net.iwinv.eyers.domain.user.board.BoardType;
import net.iwinv.eyers.domain.user.user.User;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String subTitle;
    private String content;
    private BoardType type;
    private User user;

    @Builder
    public BoardSaveRequestDto(String title, String subTitle, String content, BoardType type, User user) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.user = user;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .subTitle(subTitle)
                .content(content)
                .type(type)
                .user(user)
                .build();
    }

}
