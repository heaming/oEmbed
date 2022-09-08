package com.oembed.purpleio.dataHandler;

import com.oembed.purpleio.domain.Provider;
import org.json.simple.JSONObject;


public interface JsonDataHandler {

    public JSONObject getJsonData(Provider provider, String searchUrl) throws Exception;

}
