package com.social.socialtable.repository;

import com.social.socialtable.repository.mapping.QuestionnaireMapper;
import com.social.socialtable.service.dto.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionnaireRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    private final QuestionnaireMapper mapper;
    private SimpleJdbcInsert simpleJdbcInsert;

    private static final String TABLE_NAME = "questionnaire";

    @PostConstruct
    private void postConstruct() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns("id");
    }

    public Long addQuestionnaire(Questionnaire questionnaire) {
        Number id = simpleJdbcInsert.executeAndReturnKey(mapper.mappingObjectToMapParams(questionnaire));
        return id.longValue();
    }

    public List<Questionnaire> getAllByUsername(String username) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ?";
        List<Questionnaire> questionnaires = jdbcTemplate.query(query, mapper, username);
        return questionnaires;
    }
}