package com.oembed.purpleio.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProviderYoutube implements Provider {

    @Value("${youtube.provider_name}")
    private String providerName;

    @Value("${youtube.provider_url}")
    private String providerUrl;

    @Value("${youtube.endpoints.url}")
    private String endpointsUrl;

    public ProviderYoutube() {}

    @Override
    public String getProviderName() {
        return this.providerName;
    }

    @Override
    public String getProviderUrl() {
        return this.providerUrl;
    }

    @Override
    public String getEndpointsUrl() {
        return this.endpointsUrl;
    }
}
