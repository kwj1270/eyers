package net.iwinv.eyers1.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class H2Config {

    @Bean
    public ServletRegistrationBean h2servletRegistration(){

        ServletRegistrationBean regi = new ServletRegistrationBean(new WebServlet() );
        regi.addUrlMappings("/console/*");
        return regi;
    }
}


