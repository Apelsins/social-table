package com.social.socialtable.service.dto;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
}
