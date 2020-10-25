package net.iwinv.eyers.controller.user;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.config.annotation.LoginUser;
import net.iwinv.eyers.config.dto.SessionUser;
import net.iwinv.eyers.dto.user.UserSaveRequestDto;
import net.iwinv.eyers.service.user.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/signup/user")
    public String signup(UserSaveRequestDto requestDto){
        userService.save(requestDto);
        return "redirect:login";
    }

    @GetMapping("/user")
    public String getBoard(@LoginUser SessionUser user, Model model){
        model.addAttribute("user_detail", userService.findByUserId(user.getUserId()));
        return "user";
    }

    @GetMapping("/user/update/{userId}")
    public String postsUpdate(@PathVariable String userId, Model model){
        model.addAttribute("board",userService.findByUserId(userId));
        return "user-update";
    }


}
