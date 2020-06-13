package com.newspaper.newspaperservice;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Article implements Comparable<Article>{
    private long id;
    private Date date;
    private Date date_gmt;
    private RenderedText title;
    private RenderedText content;
    private String jetpack_featured_media_url;

    public int compareTo(Article other){
        return this.date.compareTo(other.date);
    }
}
