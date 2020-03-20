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

    @PutMapping("/api/v1/user/{user_seq}")
    public Long update(@PathVariable Long user_seq, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(user_seq,requestDto);
    }

    @GetMapping("/api/v1/user/{user_seq}")
    public UserResponseDto findById (@PathVariable Long user_seq) {
        return userService.findById(user_seq);
    }

    @DeleteMapping("/api/v1/user/{user_seq}")
    public Long delete(@PathVariable Long user_seq){
        userService.delete(user_seq);
        return user_seq;
    }


}
