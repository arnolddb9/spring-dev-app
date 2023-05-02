package com.pfcti.spring.dev.app.mvc;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {


    @RequestMapping("/oauth")
    public String oauth(Model model) {
        DefaultOidcUser principal = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String token = principal.getIdToken().getTokenValue();
        String username = principal.getPreferredUsername();
        model.addAttribute("username", username);
        model.addAttribute("token", token);
        return "oauth";
    }
}
