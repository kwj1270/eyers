package net.iwinv.eyers.dto.board;

import lombok.Getter;
import net.iwinv.eyers.domain.board.Board;
import net.iwinv.eyers.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {

    private Long id;
    private String title;
    private User user;
    private LocalDateTime modifiedDate;

    public BoardListResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.user = entity.getUser();
        this.modifiedDate = entity.getModifiedDate();
    }

}
