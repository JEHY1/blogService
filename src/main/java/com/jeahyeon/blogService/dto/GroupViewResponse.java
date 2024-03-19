package com.jeahyeon.blogService.dto;


import com.jeahyeon.blogService.domain.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class GroupViewResponse {

    private Long groupId;

    public GroupViewResponse(UserGroup userGroup){
        this.groupId = userGroup.getGroupId();
    }
}
