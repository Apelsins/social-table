package com.social.socialtable.repository;


import com.social.socialtable.service.dto.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserMapperParameters {

    public Map<String, Object> mappingUserToMap(User user) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", user.getName());
        parameters.put("second_name", user.getSecondName());
        parameters.put("age", user.getAge());
        parameters.put("sex", user.getSex());
        parameters.put("interests", user.getInterests());
        parameters.put("city", user.getCity());
        return parameters;
    }
}
