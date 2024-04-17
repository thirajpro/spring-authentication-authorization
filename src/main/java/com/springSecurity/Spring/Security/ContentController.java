package com.springSecurity.Spring.Security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class ContentController {
    @GetMapping("/home")
    public String handleWelcome(Model model) {
        model.addAttribute("name","Welcome to the Home Page");
        return "home";
    }
    @GetMapping("/admin/home")
    public String handleAdminHome(Model model){

        model.addAttribute("name","Welcome to the Admin Home page");
        return "home_admin";
}
    @GetMapping("/user/home")
    public String handleUserHome(Model model){
        model.addAttribute("name","Welcome to the User Home Page");
        return "home_user";
}

}
