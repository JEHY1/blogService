package com.jeahyeon.blogService.dto;


import com.jeahyeon.blogService.domain.GroupMaker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddGroupMakerRequest {

    private String userEmail;

    public GroupMaker toEntity(){
        return GroupMaker.builder()
                .userEmail(userEmail)
                .build();
    }
}
