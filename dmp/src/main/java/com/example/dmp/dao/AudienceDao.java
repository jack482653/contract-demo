package com.example.dmp.dao;

import com.example.dmp.model.Audience;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AudienceDao {

    public Optional<Audience> findById(String audienceId) {
        if (audienceId.equals("c8937bbe-bfbf-4200-90d5-d23313d6ac4c")) {
            return Optional.of(Audience.builder()
                .audienceId("c8937bbe-bfbf-4200-90d5-d23313d6ac4c")
                .extIds(Map.of("doubleclick", "6ebc39d5-e611-4e10-8b79-b487c4bd5951"))
                .segments(Arrays.asList("6ebc39d5-e611-4e10-8b79-b487c4bd5951", "b132054f-a7f3-49b1-b278-f5231c02e16c", "ebc64f06-7de2-4247-b440-01b54083e1ae"))
                .gender(Audience.Gender.MALE)
                .age(21)
                .build());
        } else {
            return Optional.empty();
        }
    }
}
