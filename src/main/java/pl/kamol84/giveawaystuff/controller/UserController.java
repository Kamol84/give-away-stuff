package pl.kamol84.giveawaystuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamol84.giveawaystuff.service.UserService;

@Controller
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Secured({"ROLE_USER", "ROLE_ADMIN"})

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/form")
    public String login(){
        return "user/form";
    }


}


