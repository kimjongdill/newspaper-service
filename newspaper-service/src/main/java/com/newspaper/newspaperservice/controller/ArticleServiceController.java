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

@RestController
@RequestMapping(value="/articles")
public class ArticleServiceController {

    @Autowired
    LeaderPubClient leaderPubClient;

    private final long author = 1548;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Article> getById(@PathVariable(name = "id") long id)
    {
        return new ResponseEntity<Article>(leaderPubClient.getById(author, id), HttpStatus.OK);
    }

}
