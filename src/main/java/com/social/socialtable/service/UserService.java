package com.social.socialtable.service;

import com.social.socialtable.repository.AuthorityRepository;
import com.social.socialtable.repository.UserRepository;
import com.social.socialtable.service.dto.Authority;
import com.social.socialtable.service.dto.RegisterInfo;
import com.social.socialtable.service.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    public Long registerUser(RegisterInfo registerInfo) {
        User user = new User();
        user.setUsername(registerInfo.getUsername());
        user.setPassword(passwordEncoder.encode(registerInfo.getPassword()));
        user.setEnabled(true);
        Long userId = userRepository.addUser(user);

        Authority authority = new Authority();
        authority.setUsername(registerInfo.getUsername());
        authority.setAuthority("ROLE_USER");
        authorityRepository.addAuthority(authority);

        return userId;
    }

}
