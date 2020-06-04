package com.newspaper.newspaperservice;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private long id;
    private Date date;
    private String title;
    private String content;
    private String jetpack_featured_media_url;

}
