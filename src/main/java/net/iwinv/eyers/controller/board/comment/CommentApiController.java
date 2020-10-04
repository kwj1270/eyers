package net.iwinv.eyers.controller.board.comment;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.dto.board.comment.CommentSaveRequestDto;
import net.iwinv.eyers.dto.board.comment.CommentUpdateRequestDto;
import net.iwinv.eyers.service.board.comment.CommentService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping("/api/v1/comment")
    public Long save(@RequestBody CommentSaveRequestDto requestDto){
        return commentService.save(requestDto);
    }

    @PutMapping("/api/v1/comment/{id}")
    public Long update(@PathVariable Long id, @RequestBody CommentUpdateRequestDto requestDto){
        return commentService.update(id,requestDto);
    }

    @DeleteMapping("/api/v1/comment/{id}")
    public Long delete(@PathVariable Long comment){
        commentService.delete(comment);
        return comment;
    }

}
