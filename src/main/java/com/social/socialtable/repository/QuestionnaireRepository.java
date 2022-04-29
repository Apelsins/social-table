package com.social.socialtable.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionnaireRepository {

    private final JdbcTemplate jdbcTemplate;

}
