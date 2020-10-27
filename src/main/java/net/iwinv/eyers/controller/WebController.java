package net.iwinv.eyers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@RequiredArgsConstructor
@Controller
public class WebController {

    @GetMapping("/username")
    @ResponseBody
    public String currentUserName() {
        if(hasUserRole()) return "true";
        return "false";
    }

    public boolean hasUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities.stream().filter(o -> o.getAuthority().equals("ROLE_USER")).findAny().isPresent();
    }

}
