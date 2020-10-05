package net.iwinv.eyers.controller;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class WebController {
    private final UserService userService;

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }



}
