package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private UserService userService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("user_nickname", user.getUser_nickname());
            return "redirect:main2";
        } else {
            return "redirect:login";
        }
    }

    @GetMapping("/main2")
    public String main(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("user_nickname", user.getUser_nickname());
            return "main2";
        } else {
            return "redirect:login";
        }
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
