//package com.social.socialtable.web;
//
//import com.social.socialtable.service.IndexService;
//import com.social.socialtable.service.dto.FirstnameAndSecondnameLike;
//import com.social.socialtable.service.dto.Questionnaire;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/rest/replica")
//@RequiredArgsConstructor
//public class ReplicaRESTController {
//
//    private final IndexService indexService;
//
//    @GetMapping("/open/getByFirstAndSecondName/{name}/{secondname}")
//    public List<Questionnaire> getByFirstAndSecondNameRest(@PathVariable String name, @PathVariable String secondname) {
//        FirstnameAndSecondnameLike firstnameAndSecondnameLike = new FirstnameAndSecondnameLike();
//        firstnameAndSecondnameLike.setName(name);
//        firstnameAndSecondnameLike.setSecondName(secondname);
//
//        List<Questionnaire> byFirstAndSecondName = indexService.getByFirstAndSecondName(firstnameAndSecondnameLike);
//        return byFirstAndSecondName;
//    }
//
//}
