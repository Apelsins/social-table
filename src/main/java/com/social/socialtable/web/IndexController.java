package com.social.socialtable.web;

import com.social.socialtable.service.IndexService;
import com.social.socialtable.service.dto.FirstnameAndSecondnameLike;
import com.social.socialtable.service.dto.Questionnaire;
import com.social.socialtable.service.dto.RegisterInfo;
import com.social.socialtable.service.dto.SelectedFriend;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class IndexController {

    private final IndexService indexService;

    @RequestMapping(value = "/getByFirstAndSecondName", method = RequestMethod.POST)
    public String getByFirstAndSecondName(@ModelAttribute FirstnameAndSecondnameLike firstnameAndSecondnameLike, Model model) {
        model.addAttribute("questionnaires", indexService.getByFirstAndSecondName(firstnameAndSecondnameLike));
        return "list-questionnaires";
    }

    @GetMapping("/addMillionRecords")
    public ResponseEntity<String> createMillionRecords() {
        indexService.createMillionRecords();

        return new ResponseEntity<>("1000000 анкет создались", HttpStatus.OK);
    }

}
