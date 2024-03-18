package com.jeahyeon.blogService.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class GroupMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Builder
    public GroupMaker(String userEmail){
        this.userEmail = userEmail;
    }



}
