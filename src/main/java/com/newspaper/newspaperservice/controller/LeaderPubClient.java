package com.newspaper.newspaperservice.controller;

import com.newspaper.newspaperservice.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name= "leaderpub", url = "https://www.leaderpub.com/wp-json/wp/v2")
public interface LeaderPubClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "/posts?author={author}&per_page={numArticles}",
            produces = "application/json")
    List<Article> getTopByAuthor(@PathVariable("author") Long author,
                                 @PathVariable("numArticles") Long numArticles);

}
