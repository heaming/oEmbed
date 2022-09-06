package com.oembed.purpleio.dataHandler;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonDataHandlerImpl implements JsonDataHandler {

    // field
    @Autowired
    @Qualifier("dataHandlerImpl")
    private DataHandler dataHandler;

    // ctor
    public JsonDataHandlerImpl() {
        System.out.println(this.getClass().getName());
    }

    // method
    @Override
    public JSONObject getJsonData(String url) throws Exception {

        String data = dataHandler.getData(url);

        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(data);

        System.out.println(this.getClass().getName()+ " : "+ obj);

        return obj;
    }
}
