package com.oembed.purpleio.controller;

import com.oembed.purpleio.domain.ErrorResponse;
import com.oembed.purpleio.service.SearchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HomeRestController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeRestController.class);

    @Autowired
    @Qualifier("searchServiceImpl")
    private SearchService searchService;

    @PostMapping(value="/rest/search")
    public Map<String, Object> search(@RequestBody HashMap<String, Object> jsonData) throws Exception {

        Map<String, Object> map = new LinkedHashMap<>();

        String searchUrl = (String) jsonData.get("searchUrl");
        LOGGER.info("[HomeRestController.search()] Request :: searchUrl = {}", searchUrl);

        Map<String, Object> result = searchService.search(searchUrl);

        map.put("success", new String[]{HttpStatus.OK.toString(), String.valueOf(System.currentTimeMillis())});
        map.put("requestInfo", new String[]{searchUrl, HttpStatus.CREATED.toString()});
        map.put("data", result);

        return map;
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorHandling(Exception e) {

        LOGGER.warn("[HomeRestController.errorHandling()] :: "+e.getMessage());

        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
