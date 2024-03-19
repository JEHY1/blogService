package com.jeahyeon.blogService.dto;

import com.jeahyeon.blogService.domain.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InviteRequest {

    private Long groupId;
    private String UserEmail;

    public UserGroup toEntity(){
        return UserGroup.builder()
                .groupId(groupId)
                .userEmail(UserEmail)
                .build();
    }
}
