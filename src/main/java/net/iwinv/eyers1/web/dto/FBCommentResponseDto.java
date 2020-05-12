package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.fbcomment.FBComment;

// 데이터베이스로부터 하나의 데이터를 가져올 때 사용하는 클래스
@Getter
public class FBCommentResponseDto {

    private long fbcommentSeq;
    private String fbcommentFreeboard;
    private String fbcommentName; // 작성자
    private String fbcommentContent;

    public FBCommentResponseDto(FBComment entity){
        this.fbcommentSeq = entity.getFbcommentSeq();
        this.fbcommentFreeboard = entity.getFbcommentFreeboard();
        this.fbcommentName = entity.getFbcommentName();
        this.fbcommentContent = entity.getFbcommentContent();
    }
}
