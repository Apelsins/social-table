package com.social.socialtable.repository.mapping;

import com.social.socialtable.service.dto.Friend;
import com.social.socialtable.service.dto.Questionnaire;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FriendMapper implements RowMapper<Friend> {

    @Override
    public Friend mapRow(ResultSet rs, int rowNum) throws SQLException {
        Friend friend = new Friend();
        friend.setUserId(rs.getLong("user_id"));
        friend.setFriendId(rs.getLong("friend_id"));
        return friend;
    }

    public Map<String, Object> mappingObjectToMapParams(Friend friend) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", friend.getUserId());
        parameters.put("friend_id", friend.getFriendId());
        return parameters;
    }
}

