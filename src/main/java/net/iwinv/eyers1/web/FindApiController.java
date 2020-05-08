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
    public String findId(@RequestParam("userName") String userName, @RequestParam("userStudentnumber") String userStudentnumber) {
        String findOk = userService.findId(userName, userStudentnumber);
        return findOk;
    }

    @PostMapping("/api/v1/user/find/pw")
    public String findPassword(@RequestParam("userId") String userId, @RequestParam("userName") String userName, @RequestParam("userStudentnumber") String userStudentnumber) {
        String findOk = userService.findPassword(userId, userName, userStudentnumber);
        return findOk;
    }


}
