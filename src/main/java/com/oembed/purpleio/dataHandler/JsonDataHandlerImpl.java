package com.oembed.purpleio.dataHandler;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oembed.purpleio.domain.DefaultResponseData;
import com.oembed.purpleio.domain.Provider;
import com.oembed.purpleio.domain.DataRenderer;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JsonDataHandlerImpl implements JsonDataHandler {

    // field
    @Autowired
    @Qualifier("dataHandlerImpl")
    private DataHandler dataHandler;

    @Autowired
    @Qualifier("dataRendererImpl")
    private DataRenderer renderer;

    // ctor
    public JsonDataHandlerImpl() {}

    // method
    @Override
    public JSONObject getJsonData(Provider provider, String searchUrl) throws Exception {

        String data = dataHandler.getData(provider.getProviderName(), provider.getEndpointsUrl() + searchUrl);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

        DefaultResponseData responseData = renderer.responseDataRender(provider.getProviderName());
        responseData = objectMapper.readValue(data, DefaultResponseData.class);

        JSONObject json = (JSONObject) JSONValue.parse(objectMapper.writeValueAsString(responseData));

        return json;
    }
}
