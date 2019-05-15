package pl.kamol84.giveawaystuff.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class UserController {


    @GetMapping("/form")
    public String form() {
        return "user/form";
    }


}


