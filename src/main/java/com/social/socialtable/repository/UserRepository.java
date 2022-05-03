package com.social.socialtable.repository;

import com.social.socialtable.repository.mapping.UserMapper;
import com.social.socialtable.service.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    private final UserMapper userMapperParameters;
    private SimpleJdbcInsert simpleJdbcInsert;

    private static final String TABLE_NAME = "users";

    @PostConstruct
    private void postConstruct() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns("id");
    }

    public Long addUser(User user) {
        Number aLong = simpleJdbcInsert.executeAndReturnKey(userMapperParameters.mappingObjectToMapParams(user));
        return aLong.longValue();
    }

    public Long getIdByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT id FROM " + TABLE_NAME + " where username = ?", Long.class, username);
    }

    public String getUsernameById(Long id) {
        return jdbcTemplate.queryForObject("SELECT username FROM " + TABLE_NAME + " where id = ?", String.class, id);
    }
}
