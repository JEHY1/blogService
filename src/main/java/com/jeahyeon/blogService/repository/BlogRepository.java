package com.jeahyeon.blogService.repository;

import com.jeahyeon.blogService.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
