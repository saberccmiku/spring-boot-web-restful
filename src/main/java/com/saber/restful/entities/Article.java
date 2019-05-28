package com.saber.restful.entities;

import io.searchbox.annotations.JestId;

/**
 * Created by Administrator on 2019/5/26
 */
public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
