package net.iwinv.eyers;

import net.iwinv.eyers.domain.user.user.User;
import net.iwinv.eyers.domain.user.user.UserRepository;
import net.iwinv.eyers.domain.user.user.enums.Role;
import net.iwinv.eyers.domain.user.user.enums.UserStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class Application{
    public static void main(String[] args) { SpringApplication.run(Application.class,args); }

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Bean
    public CommandLineRunner runner(UserRepository userRepository)
            throws Exception{
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .userId("kwj1270")
                    .password(bCryptPasswordEncoder.encode("rladnwo1!"))
                    .name("kimwoojae")
                    .nickName("woo")
                    .role(Role.USER)
                    .status(UserStatus.ACTIVE)
                    .studentId("201512014")
                    .build()
            );
        };
    }

}

