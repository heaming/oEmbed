package com.oembed.purpleio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oembed.purpleio.dataHandler.JsonDataHandler;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("searchServiceImpl")
public class SearchServiceImpl implements SearchService{

    // field
    @Autowired
    @Qualifier("jsonDataHandlerImpl")
    private JsonDataHandler jsonDataHandler;

    // ctor
    public SearchServiceImpl() {}

    // method
    public Map<String, Object> search(String searchUrl) throws Exception {

        String provider = "";
        Map<String, Object> result = new HashMap<>();

        // Provider URL

        if(searchUrl.contains("youtube")) {
            provider += "https://www.youtube.com/oembed?format=json&url=";
        } else if(searchUrl.contains("instagram")) {
            // instagram 불가
            provider += "https://graph.facebook.com/v10.0/instagram_oembed?url=";
        } else if(searchUrl.contains("twitter")) {
            provider += "https://publish.twitter.com/oembed?format=json&url=";
        } else if(searchUrl.contains("vimeo")) {
            provider += "https://vimeo.com/api/oembed.json?url=";
        } else {
            // 지원하지 않는 호스트
        }

        provider += searchUrl;

        System.out.println("proveider:"+provider);

        JSONObject jsonObject = jsonDataHandler.getJsonData(provider);
        result = new ObjectMapper().readValue(jsonObject.toJSONString(), Map.class);

        return result;
    }


//    @Override
//    public Map<String, Object> getYoutubeData() throws Exception {
//
//        jsonDataHandler.youtubeJsonData();
//
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> getInstagramData() throws Exception {
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> getTwitterData() throws Exception {
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> getVimeoData() throws Exception {
//        return null;
//    }
}