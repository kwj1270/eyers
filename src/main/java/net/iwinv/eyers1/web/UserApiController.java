package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.user.UserService;
import net.iwinv.eyers1.web.dto.UserResponseDto;
import net.iwinv.eyers1.web.dto.UserSaveRequestDto;
import net.iwinv.eyers1.web.dto.UserUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto){return userService.save(requestDto);}

    @PutMapping("/api/v1/user/{userSeq}")
    public Long update(@PathVariable Long userSeq, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(userSeq,requestDto);
    }

    @GetMapping("/api/v1/user/{userSeq}")
    public UserResponseDto findById (@PathVariable Long userSeq) {
        return userService.findById(userSeq);
    }

    @DeleteMapping("/api/v1/user/{userSeq}")
    public Long delete(@PathVariable Long userSeq){
        userService.delete(userSeq);
        return userSeq;
    }


}
