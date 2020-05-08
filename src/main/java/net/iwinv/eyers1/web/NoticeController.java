package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.service.notice.NoticeService;
import net.iwinv.eyers1.util.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class NoticeController {
        private final NoticeService noticeService; // @RequiredArgsConstructor 가 의존성 주입 시켜준다.
        private final HttpSession httpSession;

        @RequestMapping("/notice")
        public String toNotice(Model model, PageRequest pageable, @LoginUser SessionUser user) {
            if (user != null) {
                model.addAttribute("notice", noticeService.findAllDesc(pageable));
                return "notice";
            } else {
                return "login";
            }
        }
}
