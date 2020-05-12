package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.fbcomment.FBCommentService;
import net.iwinv.eyers1.web.dto.FBCommentResponseDto;
import net.iwinv.eyers1.web.dto.FBCommentSaveRequestDto;
import net.iwinv.eyers1.web.dto.FBCommentUpdateRequestDto;
import net.iwinv.eyers1.web.dto.FBCommentsListResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FBCommentApiController {

    private final FBCommentService fbcommentService;

    @PostMapping("/api/v1/fbcomment")
    public Long save(@RequestBody FBCommentSaveRequestDto requestDto){
        return fbcommentService.save(requestDto);
    }

    @PutMapping("/api/v1/fbcomment/{fbcommentSeq}")
    public Long update(@PathVariable Long fbcommentSeq, @RequestBody FBCommentUpdateRequestDto requestDto){
        return fbcommentService.update(fbcommentSeq,requestDto);
    }

    @GetMapping("/api/v1/fbcomment/{fbcommentFreeboard}")
    public List<FBCommentsListResponseDto> findByFreeboardDesc (@PathVariable String fbcommentFreeboard) {
        return fbcommentService.findByFreeboardDesc(fbcommentFreeboard);
    }

    @DeleteMapping("/api/v1/fbcomment/{fbcommentSeq}")
    public Long delete(@PathVariable Long fbcommentSeq){
        fbcommentService.delete(fbcommentSeq);
        return fbcommentSeq;
    }

}
