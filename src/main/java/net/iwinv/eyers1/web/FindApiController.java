package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FindApiController {
    private final UserService userService;

    @PostMapping("/api/v1/user/find/id")
    public String findId(@RequestParam("user_name") String user_name, @RequestParam("user_studentnumber") String user_studentnumber) {
        return userService.findId(user_name, user_studentnumber);
    }

    @PostMapping("/api/v1/user/find/pw")
    public String findPassword(@RequestParam("user_id") String user_id, @RequestParam("user_name") String user_name, @RequestParam("user_studentnumber") String user_studentnumber) {
        return userService.findPassword(user_id, user_name, user_studentnumber);
    }


}
