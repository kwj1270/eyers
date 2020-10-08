package net.iwinv.eyers.controller.user;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.dto.user.UserResponseDto;
import net.iwinv.eyers.dto.user.UserSaveRequestDto;
import net.iwinv.eyers.dto.user.UserUpdateRequestDto;
import net.iwinv.eyers.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto){return userService.save(requestDto);}

    @PutMapping("/api/v1/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(id, requestDto);
    }

    @GetMapping("/api/v1/user/{id}")
    public UserResponseDto findById (@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/api/v1/user/{id}")
    public Long delete(@PathVariable Long id){
        userService.delete(id);
        return id;
    }


}
