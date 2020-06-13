package com.newspaper.newspaperservice.controller;

import com.newspaper.newspaperservice.Article;
import com.newspaper.newspaperservice.ArticleRepository;
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
    ArticleRepository ar;

    private final long author = 1548;

    @GetMapping(value = "/random")
    public ResponseEntity<Article> getRandom() {
        return new ResponseEntity<Article>(ar.GetRandomArticle(), HttpStatus.OK);
    }

    @GetMapping(value = "/latest")
    public ResponseEntity<Article> getLatest() {
        return new ResponseEntity<Article>(ar.GetLatestArticle(), HttpStatus.OK);
    }

}
