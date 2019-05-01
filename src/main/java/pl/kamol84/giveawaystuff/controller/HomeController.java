package pl.kamol84.giveawaystuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kamol84.giveawaystuff.entity.User;
import pl.kamol84.giveawaystuff.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated User user, BindingResult err, Model model, HttpSession session, HttpServletRequest request) {

        if (err.hasErrors()) {
            return "login";
        }

        User logedUser = userService.checkLogin(user.getEmail(), user.getPassword());
        session.setAttribute("user", logedUser);


        return "user/form";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }
}


