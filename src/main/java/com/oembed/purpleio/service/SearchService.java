package com.oembed.purpleio.service;

import java.util.Map;

public interface SearchService {

    public Map<String, Object> search(String url) throws Exception;

}
