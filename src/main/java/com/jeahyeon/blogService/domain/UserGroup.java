package com.jeahyeon.blogService.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "user_email")
    private String userEmail;

    @Builder
    public UserGroup(Long groupId, String userEmail){
        this.groupId = groupId;
        this.userEmail = userEmail;
    }


}
