package net.iwinv.eyers.service.user;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.config.dto.SessionUser;
import net.iwinv.eyers.domain.user.User;
import net.iwinv.eyers.domain.user.UserRepository;
import net.iwinv.eyers.dto.user.UserListResponseDto;
import net.iwinv.eyers.dto.user.UserResponseDto;
import net.iwinv.eyers.dto.user.UserSaveRequestDto;
import net.iwinv.eyers.dto.user.UserUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 아이디가 없습니다" + id));
        user.update(requestDto.getName(), requestDto.getNickName(), requestDto.getPassword());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당  없습니다. id=" + id));
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id){
        User entity = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당  없습니다. id=" + id));
        return new UserResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<UserListResponseDto> findAll(){
        return userRepository.findAll().stream().map(UserListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long login(String userId, String password){
        User user = userRepository.findByUserIdAndPassword(userId, password).orElseThrow(() -> new
                IllegalArgumentException("해당 아이디 또는 비밀번호가 존재하지 않습니다."));
        httpSession.setAttribute("user", new SessionUser(user));
        return user.getId();
    }

    @Transactional(readOnly = true)
    public boolean findByUserId(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    @Transactional(readOnly = true)
    public boolean findByStudentId(String studentId) {
        return userRepository.findByStudentId(studentId).isPresent();
    }

    @Transactional(readOnly = true)
    public boolean findByNickName(String nickName) {
        return userRepository.findByNickName(nickName).isPresent();
    }


}
