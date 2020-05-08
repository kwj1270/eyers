package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 사용자가 이름을 자유롭게 정하기에
// 나는 ajax 통신에 사용될 url을 apiContoller라 정의했다.
// 즉 해당 클래스는 비동기 통신을 위한 컨트롤러이다.

@RequiredArgsConstructor  // final 선언 변수 의존성 주입
@RestController // @RestController 는 웹 페이지를 호출하는 것이 아닌 값을 출력하는 것이다. 즉, http body에 리턴된값을 보낸다.
public class JoinApiController {

    private final UserService userService; // user와 관련된 서비스 (service.user에 UserService 존재)

    @GetMapping("/api/v1/join/id/check") // id 중복 체크
    public boolean idCheck(@RequestParam("user_id") String user_id) {
        System.out.println(user_id);
        return userService.idCheck(user_id);
    }

    @GetMapping("/api/v1/join/studentnumber/check") // 학번 중복 체크
    public boolean studentnumberCheck(@RequestParam("user_studentnumber") String user_studentnumber) {
        return userService.studentnumberCheck(user_studentnumber);
    }

    @GetMapping("/api/v1/join/nickname/check") // 별명 중복 체크
    public boolean nicknameCheck(@RequestParam("user_nickname") String user_nickname) {
        return userService.nicknameCheck(user_nickname);
    }
}
