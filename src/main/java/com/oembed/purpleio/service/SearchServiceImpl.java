package com.oembed.purpleio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oembed.purpleio.dataHandler.JsonDataHandler;
import com.oembed.purpleio.domain.*;
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

    @Autowired
    @Qualifier("dataRendererImpl")
    private DataRenderer dataRenderer;

    // ctor
    public SearchServiceImpl() {}

    // method
    public Map<String, Object> search(String searchUrl) throws Exception {

        Map<String, Object> result = new HashMap<>();

        Provider provider = dataRenderer.providerRender(searchUrl);

        // Front 에 보여질 oEmbed Data
        JSONObject jsonObject = jsonDataHandler.getJsonData(provider, searchUrl);

        result = new ObjectMapper().readValue(jsonObject.toJSONString(), Map.class);

        return result;
    }
}
