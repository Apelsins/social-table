package com.social.socialtable.repository;

import com.social.socialtable.repository.mapping.FriendMapper;
import com.social.socialtable.repository.mapping.QuestionnaireMapper;
import com.social.socialtable.repository.mapping.StringMapper;
import com.social.socialtable.service.dto.Friend;
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
public class FriendRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    private final FriendMapper friendMapper;
    private final StringMapper stringMapper;
    private SimpleJdbcInsert simpleJdbcInsert;

    private static final String TABLE_NAME = "friends";

    @PostConstruct
    private void postConstruct() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns("id");
    }

    public boolean addFriend(Friend friend) {
        simpleJdbcInsert.execute(friendMapper.mappingObjectToMapParams(friend));
        return true;
    }

    public List<Friend> getAllById(Long userId) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE user_id = ?";
        List<Friend> friends = jdbcTemplate.query(query, friendMapper, userId);
        return friends;
    }

    public List<String> getAllUsernamesWithoutFriends(Long userId) {
        String query = "select username from users where id not in ( " +
                "select friend_id from friends where user_id = ?) and id != ?";
        List<String> friends = jdbcTemplate.query(query, stringMapper, userId, userId);
        return friends;
    }
}