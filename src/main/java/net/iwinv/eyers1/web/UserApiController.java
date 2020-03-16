package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.user.UserService;
import net.iwinv.eyers1.web.dto.UserSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto){return userService.save(requestDto);}
}
