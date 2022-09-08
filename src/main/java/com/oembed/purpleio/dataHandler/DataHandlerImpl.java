package com.oembed.purpleio.dataHandler;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;

@Component
public class DataHandlerImpl implements DataHandler {

    // ctor
    public DataHandlerImpl() {}

    // method
    @Override
    public String getData(String providerName, String url) throws Exception {

        // 2.3. Provider Response
        // * application/json 사용
        // * UTF-8 encoded

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpEntity entity = new HttpEntity<>(header);
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);

        return result.getBody();
    }

}
