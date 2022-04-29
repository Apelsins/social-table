package com.social.socialtable.repository;

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
    private final UserMapperParameters userMapperParameters;
    private SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    private void postConstruct() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("users").usingGeneratedKeyColumns("id");
    }

    public Long addUser(User user) {
        Number aLong = simpleJdbcInsert.executeAndReturnKey(userMapperParameters.mappingUserToMap(user));
        return aLong.longValue();
    }
}
