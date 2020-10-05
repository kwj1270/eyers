package net.iwinv.eyers.config;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.domain.user.enums.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
/*
        http    .authorizeRequests()
                .antMatchers("/","/h2-console/**","/auth/**","/login/**", "/join/**").permitAll()
                .antMatchers("/api/v1/**", "/main/**").hasRole(Role.USER.name())
                .antMatchers("/admin/**").hasRole(Role.ADMIN.name()) // h2-console 바꾸기
                .anyRequest().authenticated();
*/
        http    .authorizeRequests().antMatchers("/**").permitAll();

        http
                .exceptionHandling() // 예외사항을 설정
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
        // 인증 실패시 해당 url을 실행하도록 합니다.

        /*
            logoutSuccessHandler()
            logoutSuccessUrl 말고 LogoutSuccessHandler 인터페이스를 구현한 다른 헨들러 사용 정함
        */
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/main")
                .failureUrl("/login?error")
                .usernameParameter("userId")
                .passwordParameter("password");

        http
                .logout() // logout 관련된 설정을 진행 알림 구문 -> 이후는 logout 진행하겠다.
                .logoutUrl("/logout") // 로그아웃을 진행할 url 설정
                .logoutSuccessUrl("/login") // 로그아웃 성공시 이동 페이지
                .deleteCookies("JSESSIONID") // 로그아웃시 쿠키 지움 -> 세션 ID 쿠키 지움
                .invalidateHttpSession(true); // 로그아웃시 인증정보 지우고 세션 종료
    }

}
