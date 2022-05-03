package com.social.socialtable.repository.mapping;


import com.social.socialtable.service.dto.Authority;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthorityMapper {

    public Map<String, Object> mappingUserToAuth(Authority authority) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", authority.getUsername());
        parameters.put("authority", authority.getAuthority());
        return parameters;
    }
}
