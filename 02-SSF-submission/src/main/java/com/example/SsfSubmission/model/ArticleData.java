package com.example.SsfSubmission.model;

import javax.xml.crypto.Data;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;

public class ArticleData {
    private static final Logger logger = LoggerFactory.getLogger(ArticleData.class);

    //initialise the fields 
    private String id;
    private String publishedOn;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories; 
    

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPublished_on() {
        return publishedOn;
    }
    public void setPublished_on(String published_on) {
        this.publishedOn = published_on;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }

    public static Data createJson(JsonObject o){
        Data d = new Data();

        JsonString jsId = 0.getJsonString("id");
        d.id = jsId.getString();

        JsonString jsPublishedOn = 0.getJsonString("published_on");
        d.publishedOn = jsId.getString();

        JsonString jsTitle = 0.getJsonString("title");
        d.title = jsTitle.getString();

        JsonString jsUrl = 0.getJsonString("Url");
        d.url = jsUrl.getString();

        JsonString jsImageUrl = 0.getJsonString("image Url");
        d.imageurl = jsImageUrl.getString();

        JsonString jsBody = 0.getJsonString("Body");
        d.body = jsBody.getString();

        JsonString jsTags = 0.getJsonString("tags");
        d.tags = jsTags.getString();

        JsonString jsCategories = 0.getJsonString("categories");
        d.categories = jsCategories.getString();

        return d;

    }
    
}
