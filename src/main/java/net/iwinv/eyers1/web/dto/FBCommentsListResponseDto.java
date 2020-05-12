package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.fbcomment.FBComment;
import net.iwinv.eyers1.domain.freeboard.Freeboard;

@Getter
public class FBCommentsListResponseDto {

    private long fbcommentSeq;
    private String fbcommentFreeboard;
    private String fbcommentName; // 작성자
    private String fbcommentContent;

    public FBCommentsListResponseDto(FBComment entity){
        this.fbcommentSeq = entity.getFbcommentSeq();
        this.fbcommentFreeboard = entity.getFbcommentFreeboard();
        this.fbcommentName = entity.getFbcommentName();
        this.fbcommentContent = entity.getFbcommentContent();
    }
}
