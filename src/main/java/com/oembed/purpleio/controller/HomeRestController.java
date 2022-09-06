package com.oembed.purpleio.controller;

import com.oembed.purpleio.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeRestController {

    @Autowired
    @Qualifier("searchServiceImpl")
    private SearchService searchService;

    @RequestMapping(value="/rest/search")
    public Map<String, Object> search(Model model, @RequestBody HashMap<String, Object> jsonData) throws Exception {

        String searchUrl = (String) jsonData.get("searchUrl");

        Map<String, Object> result = searchService.search(searchUrl);
        model.addAttribute("data", result);

        return result;
    }

}
