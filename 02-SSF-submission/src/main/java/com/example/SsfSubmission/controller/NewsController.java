package com.example.SsfSubmission.controller;

import java.util.List;

import javax.xml.crypto.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Arrays;

import com.example.SsfSubmission.model.Article;
import com.example.SsfSubmission.service.NewsService;

@Controller
@RequestMapping(path = "/html")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class); 

    @Autowired
    private NewsService newsService;

    //get mapping 
    @GetMapping("/")
    public String Articles(Model model){
        Arrays arrays = new Arrays();
        List<Article> newsArrays = newsService.getArticles();

        if (newsArrays == null ){
            model.addAttribute("news", new Arrays());
            return "news";
        }

        List<Data> fld = Arrays.getFields();
        model.addAttribute("fields", fld);
        model.addAttribute("arrays", arrays);
        return "news";    
    }
    
}
