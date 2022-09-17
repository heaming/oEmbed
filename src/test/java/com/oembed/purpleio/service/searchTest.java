package com.oembed.purpleio.service;

import com.oembed.purpleio.controller.HomeController;
import com.oembed.purpleio.controller.HomeRestController;
import com.oembed.purpleio.dataHandler.DataHandler;
import com.oembed.purpleio.dataHandler.DataHandlerImpl;
import com.oembed.purpleio.dataHandler.JsonDataHandlerImpl;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class searchTest {
    private MockMvc mockMvc;

    @Autowired
    HomeRestController homeRestController;

    @Autowired
    private DataHandlerImpl dataHandler;

    @Autowired
    private JsonDataHandlerImpl jsonDataHandler;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(homeRestController).build();
    }

    @Test
    @DisplayName("[test] SearchServiceImpl.search()")
    public void searchTest() throws Exception {



        String searchUrl = "https://www.youtube.com/watch?v=NTFz9u9rzwc&t=581";

        SearchServiceImpl searchService = new SearchServiceImpl();

        Map<String, Object> testResult = searchService.search(searchUrl);


    }
}
