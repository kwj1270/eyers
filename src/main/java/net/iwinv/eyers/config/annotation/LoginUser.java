package net.iwinv.eyers.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 매개변수에서만 사용 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}

