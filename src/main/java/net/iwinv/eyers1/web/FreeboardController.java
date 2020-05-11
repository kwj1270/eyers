package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.service.freeboard.FreeboardService;
import net.iwinv.eyers1.web.dto.FreeboardsListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class FreeboardController {
    private final FreeboardService freeboardService; // @RequiredArgsConstructor 가 의존성 주입 시켜준다.
    private final HttpSession httpSession;

    @RequestMapping("/freeboard")
    public String toFreeboard(Model model, Pageable pageable, @LoginUser SessionUser user) {
        if (user != null) {
            Page<FreeboardsListResponseDto> freeboards = freeboardService.findAll(pageable);
            model.addAttribute("freeboards", freeboards);
            return "freeboard";
        } else {
            return "login";
        }
    }

    @RequestMapping("/freeboard/{freeboardSeq}")
    public String toDetailFreeboard(@PathVariable Long freeboardSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("freeboard",freeboardService.findById(freeboardSeq));
            return "freeboard-detail";
        } else {
            return "login";
        }
    }

    @RequestMapping("/freeboard/{freeboardSeq}/update")
    public String toUpdateFreeboard(@PathVariable Long freeboardSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("freeboard",freeboardService.findById(freeboardSeq));
            return "freeboard-update";
        } else {
            return "login";
        }
    }
}
