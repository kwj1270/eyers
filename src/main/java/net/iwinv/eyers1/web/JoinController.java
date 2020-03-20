package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.service.user.UserService;
import net.iwinv.eyers1.web.dto.UserSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class JoinController {

    private final UserService userService; // @RequiredArgsConstructor final 의존성 주입 시켜준다.
    private final HttpSession httpSession;

    @GetMapping("/join")
    public String toJoin(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("user_nickname", user.getUser_nickname());
            return "redirect:main2";
        }else{
            return "join";
        }
    }

    @PostMapping("/join")
    public String join(UserSaveRequestDto requestDto, @RequestParam("user_role") String user_role){
        if(user_role.equals("USER")){
            requestDto.setUser_role(Role.USER);
        } else if(user_role.equals("ADMIN")){
            requestDto.setUser_role(Role.ADMIN);
        } else{
            return "join";
        }
        SessionUser user =  new SessionUser(userService.join(requestDto));
        httpSession.setAttribute("user", user);
        return "redirect:main2";
    }

}
