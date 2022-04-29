package com.social.socialtable.service;

import com.social.socialtable.repository.QuestionnaireRepository;
import com.social.socialtable.repository.UserRepository;
import com.social.socialtable.service.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long addUser(User user) {
        return userRepository.addUser(user);
    }

}
