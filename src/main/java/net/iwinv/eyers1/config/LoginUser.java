package net.iwinv.eyers1.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 매개변수에서만 사용 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}

// 사용자 정의 어노테이션
// @LoginUser 어노테이션을 정의하여 사용하는 것
// 단 내용이 없는데 LoginUserArgumentResolver 에서 정의해줄 것이다.
