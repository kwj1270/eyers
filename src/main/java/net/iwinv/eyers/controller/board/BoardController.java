package net.iwinv.eyers.controller.board;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.config.annotation.LoginUser;
import net.iwinv.eyers.config.dto.SessionUser;
import net.iwinv.eyers.service.board.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService; // @RequiredArgsConstructor 가 의존성 주입 시켜준다.

    @GetMapping("/board")
    public String getBoard(@PageableDefault Pageable pageable, @LoginUser SessionUser user, Model model){
        model.addAttribute("boards", boardService.findAll(pageable));
        if(user != null) { model.addAttribute("userName", user.getUserName());}
        return "board";
    }

    @GetMapping("/board/save")
    public String postsSave(){
        return "board-save";
    }

    @GetMapping("/board/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        model.addAttribute("board",boardService.findById(id));
        return "board-update";
    }



}
