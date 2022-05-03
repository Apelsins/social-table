package com.social.socialtable.web;

import com.social.socialtable.service.QuestionnaireService;
import com.social.socialtable.service.dto.Questionnaire;
import com.social.socialtable.service.dto.QuestionnairesCreationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/questionnaire")
@RequiredArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @RequestMapping("/personal-page")
    public String personalQuestionnaireView(Model model) {
        model.addAttribute("questionnaires", questionnaireService.getAllByUsername());
        return "personal-page";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        QuestionnairesCreationDto questionnairesForm = new QuestionnairesCreationDto();
        questionnairesForm.addQuestionnaire(new Questionnaire());
        model.addAttribute("form", questionnairesForm);

        return "create-questionnaires-form";
    }

    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute QuestionnairesCreationDto form, Model model) {
        questionnaireService.saveAll(form.getQuestionnaires());

//        model.addAttribute("questionnaires", questionnaireService.getAllByUsername());

        return "redirect:/questionnaire/personal-page";
    }

//    @PostMapping
//    public ResponseEntity<String> registerUser(@ModelAttribute Questionnaire questionnaire) {
//        questionnaireService.addQuestionnaire(questionnaire);
//        return new ResponseEntity<>("", HttpStatus.OK);
//    }

}