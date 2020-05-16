package net.iwinv.eyers1.web.domain.user;

import net.iwinv.eyers1.domain.user.Role;
import net.iwinv.eyers1.domain.user.User;
import net.iwinv.eyers1.domain.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup(){userRepository.deleteAll();}

    @Test
    public void 회원저장_불러오기(){
        // given - 저장을 위한 테스트 데이터 준

        String userId  = "kwj1270";
        String userPw = "rladnwo1";
        String userName = "김우재";
        String userStudentnumber = "201512014";
        String userNickname = "우지르";
        Role userRole = Role.USER;

        userRepository.save(User.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userStudentnumber(userStudentnumber)
                .userNickname(userNickname)
                .userRole(userRole)
                .build());

        // when
        List<User> userList = userRepository.findAll();

        // then 테스트 준비
        User user = userList.get(0);
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getUserPw()).isEqualTo(userPw);
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getUserStudentnumber()).isEqualTo(userStudentnumber);
        assertThat(user.getUserNickname()).isEqualTo(userNickname);
        assertThat(user.getUserRole()).isEqualTo(Role.USER);
    }

}
