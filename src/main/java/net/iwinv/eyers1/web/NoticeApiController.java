package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.notice.NoticeService;
import net.iwinv.eyers1.web.dto.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/v1/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto){return noticeService.save(requestDto);}

    @PutMapping("/api/v1/notice/{noticeSeq}")
    public Long update(@PathVariable Long noticeSeq, @RequestBody NoticeUpdateRequestDto requestDto){
        return noticeService.update(noticeSeq,requestDto);
    }

    @GetMapping("/api/v1/notice/{noticeSeq}")
    public NoticeResponseDto findById (@PathVariable Long noticeSeq) {
        return noticeService.findById(noticeSeq);
    }

    @DeleteMapping("/api/v1/notice/{noticeSeq}")
    public Long delete(@PathVariable Long noticeSeq){
        noticeService.delete(noticeSeq);
        return noticeSeq;
    }

}
