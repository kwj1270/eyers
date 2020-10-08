package net.iwinv.eyers;

import net.iwinv.eyers.domain.user.User;
import net.iwinv.eyers.domain.user.UserRepository;
import net.iwinv.eyers.domain.user.enums.Role;
import net.iwinv.eyers.domain.user.enums.UserStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application{
    public static void main(String[] args) { SpringApplication.run(Application.class,args); }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository)
            throws Exception{
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .userId("kwj1270")
                    .password("rladnwo1")
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

