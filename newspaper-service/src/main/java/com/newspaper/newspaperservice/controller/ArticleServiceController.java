package com.newspaper.newspaperservice.controller;

import com.newspaper.newspaperservice.Article;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleServiceController {

    @Autowired
    LeaderPubClient leaderPubClient;

    private final long author = 1548;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Article>> getLatest()
    {
        System.out.println("In Controller\n");

        List<Article> articles = leaderPubClient.getAllByAuthor(author);
        List<Article> new_articles = new ArrayList<Article>();
        for(Article article : articles){
            Article a = Article.builder().id(article.getId()).build();
            new_articles.add(a);
        }

        return new ResponseEntity<List<Article>>(
                new_articles, HttpStatus.OK);
    }

}
