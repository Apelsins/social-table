package com.social.socialtable.service;

import com.social.socialtable.repository.FriendRepository;
import com.social.socialtable.repository.QuestionnaireRepository;
import com.social.socialtable.repository.UserRepository;
import com.social.socialtable.service.dto.Friend;
import com.social.socialtable.service.dto.Questionnaire;
import com.social.socialtable.service.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    private final QuestionnaireRepository questionnaireRepository;

    public List<String> getAllUsernamesWithoutFriends() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Long currentId = userRepository.getIdByUsername(currentUserName);

        List<String> usersWithoutFriends = friendRepository.getAllUsernamesWithoutFriends(currentId);
        return usersWithoutFriends;
    }

    public Boolean addNewFriend(String friendUsername) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Long currentId = userRepository.getIdByUsername(currentUserName);
        Long friendId = userRepository.getIdByUsername(friendUsername);

        Friend friend = new Friend();
        friend.setUserId(currentId);
        friend.setFriendId(friendId);

        return friendRepository.addFriend(friend);
    }

    public Map<String, List<Questionnaire>> getAllByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Long currentId = userRepository.getIdByUsername(currentUserName);

        List<Friend> friends = friendRepository.getAllById(currentId);

        Map<String, List<Questionnaire>> questionnairesByFriend= new LinkedHashMap<>();
        for(Friend friend: friends) {
            String friendUsername = userRepository.getUsernameById(friend.getFriendId());
            List<Questionnaire> friendQuestionnaires = questionnaireRepository.getAllByUsername(friendUsername);

            questionnairesByFriend.put(friendUsername, friendQuestionnaires);
        }
        return questionnairesByFriend;
    }
}
