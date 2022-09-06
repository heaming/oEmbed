package com.oembed.purpleio.dataHandler;

import org.json.simple.JSONObject;

import java.util.Map;

public interface JsonDataHandler {

    public JSONObject getJsonData(String url) throws Exception;

//    // youtube
//    public JSONObject youtubeJsonData(String url) throws Exception;
//
//    // instagram
//    public JSONObject instagramJsonData(String url) throws Exception;
//
//    // twitter
//    public JSONObject twitterJsonData(String url) throws Exception;
//
//    // vimeo
//    public JSONObject vimeoJsonData(String url) throws Exception;

}
