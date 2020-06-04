package com.newspaper.newspaperservice.controller;

import com.newspaper.newspaperservice.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name= "leaderpub", url = "https://www.leaderpub.com/wp-json/wp/v2/posts")
public interface LeaderPubClient {

    @GetMapping(value = "/")
    Article getLatest(Long author);

    @GetMapping(value = "/")
    Article getById(Long author, Long id);

}
