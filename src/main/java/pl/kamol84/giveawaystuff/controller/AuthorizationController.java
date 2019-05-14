package pl.kamol84.giveawaystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kamol84.giveawaystuff.entity.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String login(@RequestParam(required = false) boolean error, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, Model model, HttpServletRequest request) {
        return "register";
    }
}
