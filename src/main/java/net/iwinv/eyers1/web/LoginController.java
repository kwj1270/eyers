package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.domain.user.User;
import net.iwinv.eyers1.service.user.UserService;
import net.iwinv.eyers1.web.dto.UserLoginRequestDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String toLogin(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userNickname", user.getUserNickname());
            return "redirect:main";
        } else {
            return "login";
        }
    }

    @PostMapping("/login")
    public String login(UserLoginRequestDto requestDto,Model model) {
        User user = userService.login(requestDto);
        if (user != null && passwordEncoder.matches(requestDto.getUserPw(),user.getUserPw())) {
            httpSession.setAttribute("user", new SessionUser(user));
            return "redirect:main";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(@LoginUser SessionUser user) {
        httpSession.removeAttribute("user");
        return "redirect:login";
    }
}
