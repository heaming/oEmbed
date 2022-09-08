package com.oembed.purpleio.domain;

public interface DataRenderer {

    public Provider providerRender(String providerName);

    public DefaultResponseData responseDataRender(String providerName);

}
