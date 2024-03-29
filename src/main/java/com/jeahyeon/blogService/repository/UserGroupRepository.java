package com.jeahyeon.blogService.repository;

import com.jeahyeon.blogService.domain.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    Optional<List<UserGroup>> findByUserEmail(String userEmail);
}
