package com.social.socialtable.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @RequestMapping("/personal-page")
//    public String personalQuestionnaireView(Model model) {
//        return "personal-page";
//    }

    @RequestMapping("/add-questionnaire")
    public String addQuestionnaireView() {
        return "add-questionnaire";
    }
}