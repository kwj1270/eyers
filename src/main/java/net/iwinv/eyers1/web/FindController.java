package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class FindController {

    private final UserService userService;

    @GetMapping("/find/id")
    public String toFindId(){
        return "findId";
    }

    @GetMapping("/find/password")
    public String toFindPassword(){
        return "findPassword";
    }
}
