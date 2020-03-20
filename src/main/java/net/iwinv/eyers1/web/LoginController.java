package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.service.user.UserService;
import net.iwinv.eyers1.web.dto.UserLoginRequestDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final UserService userService; // @RequiredArgsConstructor 가 의존성 주입 시켜준다.
    private final HttpSession httpSession;

    @GetMapping("/login")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("user_nickname", user.getUser_nickname());
            return "redirect:main2";
        } else {
            return "login";
        }
    }

    @PostMapping("/login")
    public String login(@Param("user_id")String user_id, @Param("user_pw")String user_pw){
        UserLoginRequestDto requestDto = UserLoginRequestDto.builder().user_id(user_id).user_pw(user_pw).build();
        SessionUser user = new SessionUser(userService.login(requestDto));
        httpSession.setAttribute("user", user);
        return "redirect:main2";
    }
}
