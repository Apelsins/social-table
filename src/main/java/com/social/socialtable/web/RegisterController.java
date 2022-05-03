package com.social.socialtable.web;

import com.social.socialtable.service.UserService;
import com.social.socialtable.service.dto.RegisterInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@ModelAttribute RegisterInfo registerInfo) {
        Long userId = userService.registerUser(registerInfo);
        return new ResponseEntity<>("Пользователь зарегистрирован " + userId + "\n Вернитесь и зайдите", HttpStatus.OK);
    }

    @GetMapping("/principal")
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }

}