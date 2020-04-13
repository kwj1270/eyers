package net.iwinv.eyers1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정한다.
// @EnableJpaAuditing
@SpringBootApplication // @SpringBootApplication 있는 클래스가 가장 최상단 디렉토리에 위치해야 한다.
public class Application{
    public static void main(String[] args) { SpringApplication.run(Application.class,args); }
}

// 기존에는 apache tomcat을 이용하여 웹 서버를 구동시키지만
// 스프링 부트에서는 스프링 웹 서버를 사용
// 그래서 기존 apache tomcat에서는 알아서 해주기에 main 클래스와 이를 실행하는 메소드가 없지만
// spring에서는 프레임워크(라이브러리) 안에 서버가 있는 것이니 서버를 실행하는 메서드 사용하는 것임

