package com.social.socialtable.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({ "/index", "/" })
    public String index() {
        return "index";
    }

    @RequestMapping("/register-page")
    public String register() {
        return "register-page";
    }

    @RequestMapping("/add-questionnaire")
    public String addQuestionnaireView() {
        return "add-questionnaire";
    }

    @RequestMapping("/first-and-second-name")
    public String firstAndSecondNamePage() {
        return "first-and-second-name";
    }
}