package com.jeahyeon.blogService.repository;

import com.jeahyeon.blogService.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Article, Long> {

    Optional<List<Article>> findByGroup(Long group);
}
