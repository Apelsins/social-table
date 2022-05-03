package com.social.socialtable.repository.mapping;

import com.social.socialtable.service.dto.Friend;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class StringMapper implements RowMapper<String> {

    @Override
    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
    }
}

