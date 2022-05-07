package com.social.socialtable.repository;

import com.social.socialtable.repository.mapping.QuestionnaireMapper;
import com.social.socialtable.service.dto.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class QuestionnaireRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
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
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ? limit 10000";
        List<Questionnaire> questionnaires = jdbcTemplate.query(query, mapper, username);
        return questionnaires;
    }

    public List<Questionnaire> getAllByNameAndSecondname(String name, String secondname) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE name LIKE :name AND second_name LIKE :secondname ORDER BY id";
        Map<String,Object> params = new HashMap<>();
        params.put("name", name+"%");
        params.put("secondname", secondname+"%");
        List<Questionnaire> questionnaires = namedParameterJdbcTemplate.query(query, params, mapper);
        return questionnaires;
    }
}