package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.service.notice.NoticeService;
import net.iwinv.eyers1.web.dto.NoticesListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class NoticeController {
    private final NoticeService noticeService; // @RequiredArgsConstructor 가 의존성 주입 시켜준다.
    private final HttpSession httpSession;

    @RequestMapping("/notice")
    public String toNotice(Model model, Pageable pageable, @LoginUser SessionUser user) {
        if (user != null) {
            Page<NoticesListResponseDto> notices = noticeService.findAll(pageable);
            model.addAttribute("notices", notices);
            return "notice";
        } else {
            return "redirect:login";
        }
    }

    @RequestMapping("/notice/{noticeSeq}")
    public String toDetailNotice(@PathVariable Long noticeSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("notice",noticeService.findById(noticeSeq));
            return "notice-detail";
        } else {
            return "redirect:../login";
        }
    }

    @RequestMapping("/notice/{noticeSeq}/update")
    public String toUpdateNotice(@PathVariable Long noticeSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("notice",noticeService.findById(noticeSeq));
            return "notice-update";
        } else {
            return "redirect:../../login";
        }
    }
}
