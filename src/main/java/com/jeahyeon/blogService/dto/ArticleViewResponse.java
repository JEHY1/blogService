package com.jeahyeon.blogService.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.jeahyeon.blogService.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {

  private Long id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String author;


  public ArticleViewResponse(Article article) {
    this.id = article.getId();
    this.title = article.getTitle();
    this.content = article.getContent();
    this.createdAt = article.getCreatedAt();
    this.updatedAt = article.getUpdatedAt();
    this.author = article.getAuthor();
  }
}