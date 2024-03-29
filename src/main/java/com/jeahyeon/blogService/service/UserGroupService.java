package com.jeahyeon.blogService.service;

import com.jeahyeon.blogService.domain.GroupMaker;
import com.jeahyeon.blogService.domain.UserGroup;
import com.jeahyeon.blogService.dto.AddGroupMakerRequest;
import com.jeahyeon.blogService.dto.InviteRequest;
import com.jeahyeon.blogService.repository.GroupMakerRepository;
import com.jeahyeon.blogService.repository.UserGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    private final GroupMakerRepository groupMakerRepository;

    public List<UserGroup> findByUserEmail(String userEmail){
        return userGroupRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("not found groupId"));
    }

    public GroupMaker createGroup(AddGroupMakerRequest request){

        GroupMaker groupMaker = groupMakerRepository.save(request.toEntity());
        userGroupRepository.save(UserGroup.builder()
                .groupId(groupMaker.getId())
                .userEmail(groupMaker.getUserEmail())
                .build());

        return groupMaker;
    }

    public UserGroup invite(InviteRequest request){
        return userGroupRepository.save(request.toEntity());
    }

    public List<UserGroup> findAll(){
        return userGroupRepository.findAll();
    }

}
