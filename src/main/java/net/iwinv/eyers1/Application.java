package net.iwinv.eyers1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정한다.
// @EnableJpaAuditing
@SpringBootApplication // @SpringBootApplication 있는 클래스가 가장 최상단 디렉토리에 위치해야 한다.
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class,args); }
}
