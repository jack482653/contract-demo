package com.example.dmp.contoller;

import com.example.dmp.dao.AudienceDao;
import com.example.dmp.model.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AudienceController {

    @Autowired
    AudienceDao audienceDao;

    @GetMapping("/rest/audiences/{audienceId}")
    public ResponseEntity<Audience> getAudience(@PathVariable String audienceId) {
        return audienceDao
                .findById(audienceId)
                .map(audience -> new ResponseEntity<>(audience, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
