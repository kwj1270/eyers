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
    private final HttpSession httpSession; // Session을 의미 어플리케이션 전체에서 사용될 객체를 저장한다.

    @GetMapping("/join") // get 방식으로 접근시 페이지 이동 처리
    public String toJoin(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userNickname", user.getUserNickname());
            return "redirect:main2";
        }else{
            return "join";
        }
    }

    @PostMapping("/join") // post 방식으로 접근시 CRUD 중 CREATE -> Save 진행
    public String join(UserSaveRequestDto requestDto, @RequestParam("userRole") String userRole){
        // enum 에 관한 정보는 넣기 어렵기에 controller 에서 처리
        if(userRole.equals("USER")){
            requestDto.setUserRole(Role.USER);
        } else if(userRole.equals("ADMIN")){
            requestDto.setUserRole(Role.ADMIN);
        } else{
            return "join";
        }
        SessionUser user =  new SessionUser(userService.join(requestDto)); // 로그인 성공시 user 정보 가져옴
        httpSession.setAttribute("user", user); // 받아온 user 정보를 session 에 저장
        return "redirect:main2";
    }
}
