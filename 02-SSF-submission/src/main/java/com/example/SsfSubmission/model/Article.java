package com.example.SsfSubmission.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import org.slf4j.Logger;


public class Article {
    
    private static final Logger logger = LoggerFactory.getLogger(Article.class);
    private static List<Data> data;
    
    /**
     * @param json
     * @return
     * @throws IOException
     */
    public static Article createJson(String json) throws IOException{
        logger.info("Articles" + json);
        Article c = new Article();

        try (InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            JsonArray a = o.asJsonArray();

            //do we need this ?
            logger.info(">>>>!!!!" + o.keySet());
            logger.info(">>>>>values -----------" + o.values());


            if( a != null){
                List<Data> result = new ArrayList<>();

                for (Object d: a ){
                    JsonObject oData = (JsonObject) d;
                    // show the result and add them 
                    result.add(Data.createJson(oData));
                }
                logger.info("Data Created");
                Article.data = result;
            }

        }return c;

    }

    
    
    
}
