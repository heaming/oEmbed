package com.oembed.purpleio.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProviderTwitter implements Provider {

    @Value("${twitter.provider_name}")
    private String providerName;

    @Value("${twitter.provider_url}")
    private String providerUrl;

    @Value("${twitter.endpoints.url}")
    private String endpointsUrl;

    public ProviderTwitter() {}

    @Override
    public String getProviderName() {
        return providerName;
    }

    @Override
    public String getProviderUrl() {
        return providerUrl;
    }

    @Override
    public String getEndpointsUrl() {
        return endpointsUrl;
    }

}
