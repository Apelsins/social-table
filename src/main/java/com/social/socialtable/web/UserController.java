package com.social.socialtable.web;

import com.social.socialtable.service.UserService;
import com.social.socialtable.service.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@ModelAttribute User user) {
        System.out.println(user);
        userService.addUser(user);
        return new ResponseEntity<String>("Пользователь зарегистрирован", HttpStatus.OK);
    }


}
