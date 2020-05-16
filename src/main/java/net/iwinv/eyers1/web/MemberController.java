package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    @RequestMapping("/member")
    public String toNotice(@LoginUser SessionUser user) {
        if (user != null) {
            return "member";
        } else {
            return "redirect:login";
        }
    }
}
