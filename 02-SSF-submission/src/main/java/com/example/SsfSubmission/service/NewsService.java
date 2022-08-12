package com.example.SsfSubmission.service;

import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.SsfSubmission.model.Article;

@Service
public class NewsService {
    
    private static final String URL = "https://min-api.cryptocompare.com/data/v2/news/?lang=EN";

    @Value("${API_KEY}")
    private String key;

    public List<Article> getArticles() {

        String payload;

        try {
            // Create the url with query string
            String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("q", URLEncoder.encode(article, "UTF-8"))
                .queryParam("appid", key)
                .toUriString();
            
            RequestEntity<Void> req = RequestEntity.get(url).build();

            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp;

            resp = template.exchange(req, String.class);

            payload = resp.getBody();
            System.out.println("payload: " + payload);


        }catch (Exception ex){
            System.err.printf("Error: %s\n", ex.getMessage());  
            return Collections.emptyList();
        }

        return null;

    }
}
