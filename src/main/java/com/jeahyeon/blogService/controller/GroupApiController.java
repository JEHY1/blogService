package com.jeahyeon.blogService.controller;

import com.jeahyeon.blogService.domain.GroupMaker;
import com.jeahyeon.blogService.dto.AddGroupMakerRequest;
import com.jeahyeon.blogService.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class GroupApiController {

    private final UserGroupService userGroupService;

    @PostMapping("/api/group")
    public String saveGroup(Principal principal){

        userGroupService.createGroup(new AddGroupMakerRequest(principal.getName()));
        return "redirect:/articles";
    }
}
