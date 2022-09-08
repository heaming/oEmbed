package com.oembed.purpleio.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DataRendererImpl implements DataRenderer {

    @Autowired
    @Qualifier("providerYoutube")
    private Provider providerYoutube;

    @Autowired
    @Qualifier("providerTwitter")
    private Provider providerTwitter;

    @Autowired
    @Qualifier("providerVimeo")
    private Provider providerVimeo;

    private DefaultResponseData data;

    @Override
    public Provider providerRender(String searchUrl) {
        if(searchUrl.contains("youtube")) {
            return providerYoutube;
        }

        if(searchUrl.contains("twitter")) {
            return providerTwitter;
        }
        if (searchUrl.contains("vimeo")) {
            return providerVimeo;
        }

        return null;
    }

    @Override
    public DefaultResponseData responseDataRender(String providerName) {

        if(providerName.equals("Vimeo")) {
            data = new ResponseDataVimeo();
            return data;
        }

        return data;
    }
}
