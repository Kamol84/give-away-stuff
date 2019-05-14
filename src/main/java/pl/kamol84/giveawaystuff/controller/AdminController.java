package pl.kamol84.giveawaystuff.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
@Secured("ROLE_ADMIN")
public class AdminController {



}
