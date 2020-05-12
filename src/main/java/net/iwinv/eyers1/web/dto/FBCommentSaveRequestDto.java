package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwinv.eyers1.domain.fbcomment.FBComment;

@Getter
@Setter
@NoArgsConstructor
public class FBCommentSaveRequestDto {

    private String fbcommentFreeboard;
    private String fbcommentName; // 작성자
    private String fbcommentContent;

    @Builder
    public FBCommentSaveRequestDto(String fbcommentFreeboard ,String fbcommentName, String fbcommentContent){
        this.fbcommentFreeboard = fbcommentFreeboard;
        this.fbcommentName = fbcommentName;
        this.fbcommentContent = fbcommentContent;
    }

    public FBComment toEntity(){
        return FBComment.builder()
                .fbcommentFreeboard(this.fbcommentFreeboard)
                .fbcommentName(this.fbcommentName)
                .fbcommentContent(this.fbcommentContent)
                .build();
    }
}
