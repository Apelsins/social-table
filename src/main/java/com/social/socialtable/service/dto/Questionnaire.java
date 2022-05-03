package com.social.socialtable.service.dto;

import lombok.Data;

@Data
public class Questionnaire {
    private Long id;
    private String username;
    private String name;
    private String secondName;
    private Integer age;
    private String sex;
    private String interests;
    private String city;
}
