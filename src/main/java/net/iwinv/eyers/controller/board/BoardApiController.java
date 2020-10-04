package net.iwinv.eyers.controller.board;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.dto.board.BoardResponseDto;
import net.iwinv.eyers.dto.board.BoardSaveRequestDto;
import net.iwinv.eyers.dto.board.BoardUpdateRequestDto;
import net.iwinv.eyers.service.board.BoardService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto requestDto){return boardService.save(requestDto);}

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto){
        return boardService.update(id,requestDto);
    }

    @GetMapping("/api/v1/board/{id}")
    public BoardResponseDto findById (@PathVariable Long id) {
        return boardService.findById(id);
    }

    @DeleteMapping("/api/v1/board/{id}")
    public Long delete(@PathVariable Long id){
        boardService.delete(id);
        return id;
    }

}
