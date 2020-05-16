package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class FaqController {
    @GetMapping("/faq")
    public String toLogin(@LoginUser SessionUser user) {
        if (user != null) {
            return "faq";
        } else {
            return "redirect:login";
        }
    }
}
