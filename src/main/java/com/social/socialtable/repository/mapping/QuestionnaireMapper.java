package com.social.socialtable.repository.mapping;

import com.social.socialtable.service.dto.Questionnaire;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class QuestionnaireMapper implements RowMapper<Questionnaire> {

    @Override
    public Questionnaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId(rs.getLong("id"));
        questionnaire.setUsername(rs.getString("username"));
        questionnaire.setName(rs.getString("name"));
        questionnaire.setSecondName(rs.getString("second_name"));
        questionnaire.setAge(rs.getInt("age"));
        questionnaire.setSex(rs.getString("sex"));
        questionnaire.setInterests(rs.getString("interests"));
        questionnaire.setCity(rs.getString("city"));

        return questionnaire;
    }

    public Map<String, Object> mappingObjectToMapParams(Questionnaire questionnaire) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", questionnaire.getUsername());
        parameters.put("name", questionnaire.getName());
        parameters.put("second_name", questionnaire.getSecondName());
        parameters.put("age", questionnaire.getAge());
        parameters.put("sex", questionnaire.getSex());
        parameters.put("interests", questionnaire.getInterests());
        parameters.put("city", questionnaire.getCity());
        return parameters;
    }
}

