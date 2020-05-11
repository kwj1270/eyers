package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// User에서 업데이트시 필요한 데이터만 모아놓은 클래스
@Getter
@NoArgsConstructor
public class FBCommentUpdateRequestDto {


    private String fbcommentContent;

    @Builder
    public FBCommentUpdateRequestDto(String fbcommentContent){
        this.fbcommentContent = fbcommentContent;
    }

}
