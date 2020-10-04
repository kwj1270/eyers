package net.iwinv.eyers.controller.board;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.config.LoginUser;
import net.iwinv.eyers.config.dto.SessionUser;
import net.iwinv.eyers.service.board.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService; // @RequiredArgsConstructor 가 의존성 주입 시켜준다.
/*
    @RequestMapping("/board")
    public String toFreeboard(Model model, Pageable pageable, @LoginUser SessionUser user) {
        if (user != null) {
            Page<FreeboardsListResponseDto> freeboards = boardService.findAll(pageable);
            model.addAttribute("freeboards", freeboards);
            return "freeboard";
        } else {
            return "redirect:login";
        }
    }

    @RequestMapping("/freeboard/write")
    public String toWriteFreeboard(@LoginUser SessionUser user) {
        if (user != null) {
            return "freeboard-write";
        } else {
            return "redirect:../login";
        }
    }
    @RequestMapping("/freeboard/{freeboardSeq}")
    public String toDetailFreeboard(@PathVariable Long freeboardSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("freeboard", boardService.findById(freeboardSeq));
            return "freeboard-detail";
        } else {
            return "redirect:../login";
        }
    }

    @RequestMapping("/freeboard/{freeboardSeq}/update")
    public String toUpdateFreeboard(@PathVariable Long freeboardSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("freeboard", boardService.findById(freeboardSeq));
            return "freeboard-update";
        } else {
            return "redirect:../../login";
        }
    }

 */
}
