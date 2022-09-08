package com.oembed.purpleio.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Component
public class ProviderVimeo implements Provider {

    @Value("${vimeo.provider_name}")
    private String providerName;

    @Value("${vimeo.provider_url}")
    private String providerUrl;

    @Value("${vimeo.endpoints.url}")
    private String endpointsUrl;

    public ProviderVimeo() {}

    @Override
    public String getProviderName() {
        System.out.println(providerName);
        return this.providerName;
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
