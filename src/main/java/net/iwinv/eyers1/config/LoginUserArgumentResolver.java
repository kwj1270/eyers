package net.iwinv.eyers1.config;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.dto.SessionUser;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor // final 선언된 변수에 의존성 주입 진행
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession; // session

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        return isLoginUserAnnotation && isUserClass;
    }
    // 간단히 말하면 메소드의 매개변수(파라미터)에서 @LoginUser가 동작되게끔 만드는 것

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
    // 실제 정의된 내용이며 session에 user라는 key로 정의된 객체를 Session 참조형 변수에 할당
    // function(@LoginUser Session user) 일 경우
    // user = httpSession.getAttribute("user"); 와 같이 동작 시켜준다.
}
