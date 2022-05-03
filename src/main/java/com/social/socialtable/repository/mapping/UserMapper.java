package com.social.socialtable.repository.mapping;


import com.social.socialtable.service.dto.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserMapper {

    public Map<String, Object> mappingObjectToMapParams(User user) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", user.getUsername());
        parameters.put("password", user.getPassword());
        parameters.put("enabled", user.getEnabled());
        return parameters;
    }

    public Map<String, Object> mappingUserToAuth(User user) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", user.getUsername());
        parameters.put("authority", "ROLE_USER");
        return parameters;
    }
}
