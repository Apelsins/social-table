package com.social.socialtable.service;

import com.social.socialtable.repository.QuestionnaireRepository;
import com.social.socialtable.service.dto.FirstnameAndSecondnameLike;
import com.social.socialtable.service.dto.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class IndexService {

    private final QuestionnaireRepository questionnaireRepository;

    public void createMillionRecords() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Random random = new Random();
        for (int counter = 0; counter < 10000; counter++) {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setUsername(currentUserName);
            questionnaire.setName(RandomStringUtils.random(10, true, false));
            questionnaire.setSecondName(RandomStringUtils.random(10, true, false));
            questionnaire.setAge(random.nextInt(100));
            questionnaire.setSex(RandomStringUtils.random(1, "MW"));
            questionnaire.setInterests(RandomStringUtils.random(10, true, false));
            questionnaire.setCity(RandomStringUtils.random(10, true, false));
            questionnaireRepository.addQuestionnaire(questionnaire);
        }
    }

    public List<Questionnaire> getByFirstAndSecondName(FirstnameAndSecondnameLike firstnameAndSecondnameLike){
        List<Questionnaire> allByNameAndSecondname = questionnaireRepository.getAllByNameAndSecondname(firstnameAndSecondnameLike.getName(), firstnameAndSecondnameLike.getSecondName());
        return allByNameAndSecondname;
    }
}
