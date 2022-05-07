package com.social.socialtable.web;

import com.social.socialtable.service.IndexService;
import com.social.socialtable.service.dto.FirstnameAndSecondnameLike;
import com.social.socialtable.service.dto.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/index")
@RequiredArgsConstructor
public class IndexRESTController {

    private final IndexService indexService;

    @GetMapping("/open/getByFirstAndSecondName/{name}/{secondname}")
    public List<Questionnaire> getByFirstAndSecondNameRest(@PathVariable String name, @PathVariable String secondname) {
        FirstnameAndSecondnameLike firstnameAndSecondnameLike = new FirstnameAndSecondnameLike();
        firstnameAndSecondnameLike.setName(name);
        firstnameAndSecondnameLike.setSecondName(secondname);

        List<Questionnaire> byFirstAndSecondName = indexService.getByFirstAndSecondName(firstnameAndSecondnameLike);
        return byFirstAndSecondName;
    }
}
