package net.iwinv.eyers1.web;

import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.domain.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = IndexController.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mvc;

    private MockHttpSession httpSession = null;
    private MockHttpServletRequest httpServletRequest = null;

    @Before
    public void setUp() throws Exception{
        User user = User.builder().user_nickname("kwj1270").build();
        httpSession = new MockHttpSession();
        httpSession.setAttribute("user", new SessionUser(user));
        httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setSession(httpSession);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(httpServletRequest));
    }

    @After
    public void clear(){
        httpSession.clearAttributes();
        httpSession = null;
    }

    @Test
    public void 헬로페이지_로딩()throws Exception{
        String hello = "hello world";
        mvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void 로그인페이지_로딩()throws Exception{
        httpSession.removeAttribute("user");

        String login = "login world";
        mvc.perform(get("/")
                .session(httpSession)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(login));
    }

    @Test
    public void 메인페이지_로딩()throws Exception{
        String main = "main world!";
        mvc.perform(get("/")
                .session(httpSession)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(main));
    }
        // 인덱스 컨트롤에서 main2로 일단 설정해둠
        // main 변경시 main 내용들도 테스트 할 수 있도록

}
