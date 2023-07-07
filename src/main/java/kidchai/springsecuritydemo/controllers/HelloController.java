package kidchai.springsecuritydemo.controllers;

import kidchai.springsecuritydemo.security.UserWithDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserWithDetails userWithDetails = (UserWithDetails) authentication.getPrincipal();
        System.out.println(userWithDetails.getUser());

        return "hello";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }
}
