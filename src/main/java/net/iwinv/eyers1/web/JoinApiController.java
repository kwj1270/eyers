package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JoinApiController {

    private final UserService userService;

    @GetMapping("/api/v1/join/id/check")
    public boolean idCheck(@RequestParam("user_id") String user_id) {
        return userService.idCheck(user_id);
    }


    @GetMapping("/api/v1/join/studentnumber/check")
    public boolean studentnumberCheck(@RequestParam("user_studentnumber") String user_studentnumber) {
        return userService.studentnumberCheck(user_studentnumber);
    }


    @GetMapping("/api/v1/join/nickname/check")
    public boolean nicknameCheck(@RequestParam("user_nickname") String user_nickname) {
        return userService.nicknameCheck(user_nickname);
    }
}
