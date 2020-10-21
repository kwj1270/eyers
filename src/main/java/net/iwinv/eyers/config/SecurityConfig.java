package net.iwinv.eyers.config;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.domain.user.user.enums.Role;
import net.iwinv.eyers.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService; //

    /*
     * 비밀번호 암호화
     */
    @Bean
    public PasswordEncoder passwordEncoder() { // 4
        return new BCryptPasswordEncoder();
    }

    /*
     * 스프링 시큐리티 룰을 무시하게 하는 Url 규칙.
     * 주로 리소스와 관련된 용도에서 사용된다.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/css/**")
                .antMatchers("/vendor/**")
                .antMatchers("/js/**")
                .antMatchers("/favicon*/**")
                .antMatchers("/h2-console/**")
                .antMatchers("/images/**");
    }

    /*
     * 스프링 시큐리티에 대한 제한 설정하기
     * url 설정에 주로 사용한다.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        http
                .addFilterBefore(filter, CsrfFilter.class).csrf().disable().headers().frameOptions().disable();

        http    .authorizeRequests()
                .antMatchers("/", "/login/**", "/loginProcess", "/signup/**").permitAll()
                .antMatchers("/main/**").hasAnyRole(Role.GUEST.name(), Role.USER.name(), Role.ADMIN.name())
                .antMatchers("/api/v1/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                .antMatchers("/admin/**").hasRole(Role.ADMIN.name()) // h2-console 바꾸기
                .anyRequest().authenticated();

        http
                .exceptionHandling() // 예외사항을 설정
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));

        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess")
                .defaultSuccessUrl("/main")
                .failureUrl("/login?error") // error 리턴
                .usernameParameter("userId")
                .passwordParameter("password");

        http
                .logout() // logout 관련된 설정을 진행 알림 구문 -> 이후는 logout 진행하겠다.
                .logoutSuccessUrl("/login") // 로그아웃 성공시 이동 페이지
                .deleteCookies("JSESSIONID") // 로그아웃시 쿠키 지움 -> 세션 ID 쿠키 지움
                .invalidateHttpSession(true); // 로그아웃시 인증정보 지우고 세션 종료
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

}
