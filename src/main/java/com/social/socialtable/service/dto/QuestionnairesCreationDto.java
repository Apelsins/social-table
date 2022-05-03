package com.social.socialtable.service.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionnairesCreationDto {

    private List<Questionnaire> questionnaires;

    public QuestionnairesCreationDto() {
        this.questionnaires = new ArrayList<>();
    }

    public QuestionnairesCreationDto(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public void addQuestionnaire(Questionnaire questionnaire) {
        this.questionnaires.add(questionnaire);
    }
}
