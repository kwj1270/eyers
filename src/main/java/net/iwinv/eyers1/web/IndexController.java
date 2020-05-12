package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// 인덱스 화면에서 벌어질 수 있는 모든 페이징처리에 관한 컨트롤러
@RequiredArgsConstructor // final 선언된 변수에 대하여 의존성 주입
@Controller  // String 반환시에 해당 문자열을 이름으로 가지는 html 호출
public class IndexController {
    private final UserService userService;


    // 여기서 매개변수 (Model model, @LoginUser SessionUser user)는 어디서 값을 받는 것일까?
    // 정답은 스프링 컨테이너에서 객체를 생성해주고 값을 할당 받아서 해당 메소드에 값을 넣어주는 것이다.
    // 더 정확히 말하면 스프링 컨테이너에서 해당 메소드를 호출해서 사용한다고 보면 된다.
    // 스프링 컨테이너는 우리가 제어할 수 있는 범위가 아니다 -> 그래서 프레임워크라 한다.(우리가 해당 방식에 맞춰 사용해야 하므로)

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userNickname", user.getUserNickname());
            return "redirect:main";
        } else {
            return "redirect:login";
        }
    }
    // model을 사용하는 이유는 해당 웹페이지로 넘어갈 때 페이지에서 특정 객체를 필요하면
    // 이 객체를 model에 넣어서 보내줌으로 페이지에서는 해당 객체를 사용할 수 있게 된다.

    @GetMapping("/main")
    public String main(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userNickname", user.getUserNickname());
            return "main";
        } else {
            return "redirect:login";
        }
    }

    // @LoginUser 는 사용자 정의 어노테이션인데 net.iwinv.eyers1.config에 정의된 클래스들의 결과이다.
    // 이 어노테이션이 존재하는 이유는 세션에 user 정보 값이 저장되었으면 변수 user에 값을 넣어준다.
    // 로그인시 로그인 인증 정보를 세션에 저장하는데 이말은 해당 어노테이션을 가지고 로그인 유무를 확인하는 것이다.

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/find")
    public String find(){
        return "find";
    }


    @GetMapping("/utterances")
    public String utterances(){
        return "utterances";
    }

}
