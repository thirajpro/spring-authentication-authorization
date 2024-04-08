package com.springSecurity.Spring.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class ContentController {
    @GetMapping("/home")
    public String handleWelcome(){
        return "home";
    }
    @GetMapping("/admin/home")
    public String handleAdminHome(){
        return "home_admin";
}
    @GetMapping("/user/home")
    public String handleUserHome(){
        return "home_user";
}
    @GetMapping("/error")
    public String handleError(){
        return "error";
    }

}
