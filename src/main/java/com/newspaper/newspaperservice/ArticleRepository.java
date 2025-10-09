package com.newspaper.newspaperservice;

import com.newspaper.newspaperservice.controller.LeaderPubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Component
public class ArticleRepository {

    @Autowired
    LeaderPubClient lpc;

    private CopyOnWriteArraySet<Article> articles;
    private Random random;
    private LocalDateTime nextFetch;
    private final long refreshInterval = 4; // Hours
    private final long author = 1548;
    private final Pattern removeScripts = Pattern.compile("<script>.*</script>", Pattern.CASE_INSENSITIVE);

    public ArticleRepository()
    {
        this.articles = new CopyOnWriteArraySet<Article>();
        this.random = new Random();
        this.nextFetch = LocalDateTime.MIN;
    }

    public Article GetRandomArticle()
    {
        getNewArticle();
        Integer numArticles = articles.size();
        Integer randArticle = random.nextInt(numArticles);
        Article[] arr = {};
        arr = this.articles.toArray(arr);
        
        return arr[randArticle];
    }

    public Article GetLatestArticle()
    {
        getNewArticle();
        Article[] arr = {};
        arr = this.articles.toArray(arr);
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    private void getNewArticle()
    {
        if(nextFetch.compareTo(LocalDateTime.now()) < 0 ){
            // get new articles
            this.articles.addAll(lpc.getTopByAuthor(this.author, 100l));
            this.nextFetch = LocalDateTime.now().plusHours(refreshInterval);
        }
    }

}
