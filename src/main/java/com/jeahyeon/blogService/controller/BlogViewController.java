package com.jeahyeon.blogService.controller;

import com.jeahyeon.blogService.domain.UserGroup;
import com.jeahyeon.blogService.dto.GroupViewResponse;
import com.jeahyeon.blogService.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import com.jeahyeon.blogService.domain.Article;
import com.jeahyeon.blogService.dto.ArticleListViewResponse;
import com.jeahyeon.blogService.dto.ArticleViewResponse;
import com.jeahyeon.blogService.service.BlogService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;
    private final UserGroupService userGroupService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        System.err.println("call get articles");
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        List<GroupViewResponse> groups = userGroupService.findByUserEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .stream()
                .map(GroupViewResponse::new)
                .toList();


        System.err.println("groups : " + groups);

        model.addAttribute("groups", groups);
        model.addAttribute("principal", SecurityContextHolder.getContext().getAuthentication().getName());


        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }


    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }

    @GetMapping("/home")
    public String home(Model model){

        List<GroupViewResponse> groups = userGroupService.findByUserEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .stream()
                .map(GroupViewResponse::new)
                .toList();
        model.addAttribute("groups", groups);

        return "home";
    }
}