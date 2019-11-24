package com.example.biddingengine.controller;

import com.example.biddingengine.external.AudienceApi;
import com.example.biddingengine.model.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BidController {

    @Autowired
    private AudienceApi audienceApi;

    @PostMapping("/bid/{audienceId}")
    public ResponseEntity<Map> bid(String audienceId) throws Exception {
        Audience audience = audienceApi.getAudience(audienceId);

        if (audience != null) {
            Map rst = Map.of(
                    "status", "bid",
                    "audience", audience
            );
            return new ResponseEntity<>(rst, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
