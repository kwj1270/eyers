package net.iwinv.eyers.domain.user;

import net.iwinv.eyers.domain.user.user.User;
import net.iwinv.eyers.domain.user.user.UserRepository;
import net.iwinv.eyers.domain.user.user.enums.Role;
import net.iwinv.eyers.domain.user.user.enums.UserStatus;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    private final String NAME = "김우재";
    private final String USERID = "test";
    private final String PASSWORD = "password";
    private final String STUDENTID = "111110000";
    private final String NICKNAME = "우지르";
    private final UserStatus USERSTATUS= UserStatus.ACTIVE;
    private final Role ROLE = Role.USER;

    @After
    public void clear(){
        userRepository.deleteAll();
    }

    @Test
    public void User_저장(){

        User user = User.builder()
                .name(NAME)
                .userId(USERID)
                .password(PASSWORD)
                .studentId(STUDENTID)
                .nickName(NICKNAME)
                .status(USERSTATUS)
                .role(ROLE)
                .build();

        userRepository.save(user);
        User user2 = userRepository.findByUserId(USERID).orElseThrow(() ->
                new IllegalArgumentException("해당 아이디는 존재하지 않스빈다."));

        assertThat(user2.getId()).isEqualTo(1L);
        assertThat(user2.getUserId()).isEqualTo(USERID);
        assertThat(user2.getPassword()).isEqualTo(PASSWORD);
        assertThat(user2.getStudentId()).isEqualTo(STUDENTID);
        assertThat(user2.getNickName()).isEqualTo(NICKNAME);
        assertThat(user2.getStatus()).isEqualTo(USERSTATUS);
        assertThat(user2.getRole()).isEqualTo(Role.USER);

    }

    @Test
    public void User_삭제(){
        User_저장();
        userRepository.deleteById(1L);
    }

}
