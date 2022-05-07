package com.social.socialtable.service;

import com.social.socialtable.repository.QuestionnaireRepository;
import com.social.socialtable.service.dto.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    public void saveAll(List<Questionnaire> questionnaires) {
        for (Questionnaire questionnaire : questionnaires) {
            addQuestionnaire(questionnaire);
        }
    }

    public Long addQuestionnaire(Questionnaire questionnaire) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        questionnaire.setUsername(currentUserName);

        return questionnaireRepository.addQuestionnaire(questionnaire);
    }

    public List<Questionnaire> getAllByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        return questionnaireRepository.getAllByUsername(currentUserName);
    }
}
