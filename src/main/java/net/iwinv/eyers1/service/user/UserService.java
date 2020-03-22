package net.iwinv.eyers1.service.user;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.domain.user.User;
import net.iwinv.eyers1.domain.user.UserRepository;
import net.iwinv.eyers1.web.dto.UserLoginRequestDto;
import net.iwinv.eyers1.web.dto.UserResponseDto;
import net.iwinv.eyers1.web.dto.UserSaveRequestDto;
import net.iwinv.eyers1.web.dto.UserUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional  // 저장하고 seq 값 반환
    public Long save(UserSaveRequestDto requestDto){return userRepository.save(requestDto.toEntity()).getUser_seq();}

    @Transactional  // User 반환
    public User join(UserSaveRequestDto requestDto){
        return userRepository.save(requestDto.toEntity());
    }

    @Transactional // id 중복 체크
    public boolean idCheck(String user_id){
        User user = userRepository.idCheck(user_id);
        boolean useOk = false;
        if(user == null){
            useOk = true;
        }
        return useOk;
    }

    @Transactional  // 학번 중복 체크
    public boolean studentnumberCheck(String user_studentnumber){
        User user = userRepository.studentnumberCheck(user_studentnumber);
        boolean useOk = false;
        if(user == null){
            useOk = true;
        }
        return useOk;
    }

    @Transactional  // 별명 중복 체크
    public boolean nicknameCheck(String user_nickname){
        User user = userRepository.nicknameCheck(user_nickname);
        boolean useOk = false;
        if(user == null){
            useOk = true;
        }
        return useOk;
    }

    @Transactional  // 업데이트 하고 seq 값 반
    public Long update(Long user_seq, UserUpdateRequestDto requestDto){ // 바꿀 대상이랑 매개변수 받기 (spring 컨테이너를 통한 객체 자동 생성 및 주입)
        User user = userRepository.findById(user_seq).orElseThrow(() -> // 람다식 사용 있으면 반환 없으면 던져라 (매개변수로 들어간 익명 객체)
                new IllegalArgumentException("해당 아이디가 없습니다"+user_seq)); //  없으면 null 안주고 에러 발생
        user.update(requestDto.getUser_pw(), requestDto.getUser_nickname()); // update 객체를 이용한 update 진행
        return user_seq;    // 에러가 없다면 pk를 보내 성공 여부 알려
    }

    @Transactional // 유저 정보가 존재하는지 확인
    public UserResponseDto findById(Long user_seq){ //
        User entity = userRepository.findById(user_seq).orElseThrow(() -> new
                IllegalArgumentException("헤당 아이디 없습니다. id="+user_seq));
        return new UserResponseDto(entity);
    }

    @Transactional // 유저 정보 삭제
    public void delete (Long user_seq){
        User user = userRepository.findById(user_seq).orElseThrow(()->new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ user_seq));
        userRepository.delete(user);
    }
    @Transactional  // 아이디 패스워드 일치하면 유저정보 가져오기
    public User login(UserLoginRequestDto requestDto){
        return userRepository.login(requestDto.getUser_id(),requestDto.getUser_pw());
    }

}
