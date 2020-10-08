package net.iwinv.eyers.controller.user;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.dto.user.UserSaveRequestDto;
import net.iwinv.eyers.service.user.UserService;
import org.springframework.stereotype.Controller;
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


}
