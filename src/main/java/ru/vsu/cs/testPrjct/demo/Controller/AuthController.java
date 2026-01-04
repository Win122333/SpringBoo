package ru.vsu.cs.testPrjct.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/registration")
    public String registration(Model model) {
        return "auth/registration";
    }
}
