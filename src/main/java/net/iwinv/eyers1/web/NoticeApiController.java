package net.iwinv.eyers1.web;

import lombok.NoArgsConstructor;
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

    @PutMapping("/api/v1/notice/{user_seq}")
    public Long update(@PathVariable Long notice_seq, @RequestBody NoticeUpdateRequestDto requestDto){
        return noticeService.update(notice_seq,requestDto);
    }

    @GetMapping("/api/v1/notice/{notice_seq}")
    public NoticeResponseDto findById (@PathVariable Long notice_seq) {
        return noticeService.findById(notice_seq);
    }

    @DeleteMapping("/api/v1/notice/{notice_seq}")
    public Long delete(@PathVariable Long notice_seq){
        noticeService.delete(notice_seq);
        return notice_seq;
    }

}
