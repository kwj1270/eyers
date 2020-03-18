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

        String user_id  = "kwj1270";
        String user_pw = "rladnwo1";
        String user_name = "김우재";
        String user_studentnumber = "201512014";
        String user_nickname = "우지르";
        Role user_role = Role.USER;

        userRepository.save(User.builder()
                .user_id(user_id)
                .user_pw(user_pw)
                .user_name(user_name)
                .user_studentnumber(user_studentnumber)
                .user_nickname(user_nickname)
                .user_role(user_role)
                .build());

        // when
        List<User> userList = userRepository.findAll();

        // then 테스트 준비
        User user = userList.get(0);
        assertThat(user.getUser_id()).isEqualTo(user_id);
        assertThat(user.getUser_pw()).isEqualTo(user_pw);
        assertThat(user.getUser_name()).isEqualTo(user_name);
        assertThat(user.getUser_studentnumber()).isEqualTo(user_studentnumber);
        assertThat(user.getUser_nickname()).isEqualTo(user_nickname);
        assertThat(user.getUser_role()).isEqualTo(Role.USER);
    }

}
