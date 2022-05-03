package com.social.socialtable.repository;

import com.social.socialtable.repository.mapping.AuthorityMapper;
import com.social.socialtable.service.dto.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
@RequiredArgsConstructor
public class AuthorityRepository {

    private final DataSource dataSource;
    private final AuthorityMapper mapping;
    private SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    private void postConstruct() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("authorities").usingGeneratedKeyColumns("id");
    }

    public Long addAuthority(Authority authority) {
        Number aLong = simpleJdbcInsert.executeAndReturnKey(mapping.mappingUserToAuth(authority));
        return aLong.longValue();
    }
}
