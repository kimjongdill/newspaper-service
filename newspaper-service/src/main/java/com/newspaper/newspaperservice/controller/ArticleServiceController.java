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
    public ResponseEntity<List<Article>> getAll() {

        List<Article> articles = leaderPubClient.getTopByAuthor(author, 100l);

        return new ResponseEntity<List<Article>>(
                articles, HttpStatus.OK);
    }

    @GetMapping(value = "/latest")
    public ResponseEntity<Article> getLatest() {

        Article article = leaderPubClient.getTopByAuthor(author, 1l).get(0);

        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }

}
