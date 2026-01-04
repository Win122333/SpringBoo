package ru.vsu.cs.testPrjct.demo.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.testPrjct.demo.Entity.Roles;
import ru.vsu.cs.testPrjct.demo.Entity.UserEntity;
import ru.vsu.cs.testPrjct.demo.Service.UserService;

import java.net.URI;

@Slf4j
@Controller()
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public String createUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam(required = false) boolean isAdmin
            ) {
        log.info("create new USER");
        userService.save(
                new UserEntity(username,
                password,
                isAdmin?Roles.ROLE_ADMIN:Roles.ROLE_USER
                ));
        return "auth/succsess";
    }
}
