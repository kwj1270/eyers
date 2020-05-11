package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.freeboard.FreeboardService;
import net.iwinv.eyers1.web.dto.FreeboardResponseDto;
import net.iwinv.eyers1.web.dto.FreeboardSaveRequestDto;
import net.iwinv.eyers1.web.dto.FreeboardUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FreeboardApiController {

    private final FreeboardService freeboardService;

    @PostMapping("/api/v1/freeboard")
    public Long save(@RequestBody FreeboardSaveRequestDto requestDto){return freeboardService.save(requestDto);}

    @PutMapping("/api/v1/freeboard/{freeboardSeq}")
    public Long update(@PathVariable Long freeboardSeq, @RequestBody FreeboardUpdateRequestDto requestDto){
        return freeboardService.update(freeboardSeq,requestDto);
    }

    @GetMapping("/api/v1/freeboard/{freeboardSeq}")
    public FreeboardResponseDto findById (@PathVariable Long freeboardSeq) {
        return freeboardService.findById(freeboardSeq);
    }

    @DeleteMapping("/api/v1/freeboard/{freeboardSeq}")
    public Long delete(@PathVariable Long freeboardSeq){
        freeboardService.delete(freeboardSeq);
        return freeboardSeq;
    }

}
