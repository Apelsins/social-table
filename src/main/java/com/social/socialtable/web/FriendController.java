package com.social.socialtable.web;

import com.social.socialtable.service.FriendService;
import com.social.socialtable.service.dto.QuestionnairesCreationDto;
import com.social.socialtable.service.dto.SelectedFriend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @RequestMapping("/page")
    public String friendsView(Model model) {
        model.addAttribute("questionnairesByFriend", friendService.getAllByUsername());
        return "friend-page";
    }

    @RequestMapping("/add")
    public String addFriend(Model model) {
        model.addAttribute("allUsernamesWithoutFriends", friendService.getAllUsernamesWithoutFriends());
        model.addAttribute("selectedFriend", new SelectedFriend());
        return "friend-select";
    }

    @PostMapping(value = "/save")
    public String saveFriend(@ModelAttribute SelectedFriend selectedFriend, Model model) {
        friendService.addNewFriend(selectedFriend.getFriendUsername());

//        model.addAttribute("questionnaires", questionnaireService.getAllByUsername());

        return "redirect:/friend/page";
    }

}
