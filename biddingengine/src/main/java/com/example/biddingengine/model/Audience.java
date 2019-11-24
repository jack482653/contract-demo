package com.example.biddingengine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Audience {
    @JsonProperty("audience_id")
    private String audienceId;

    @JsonProperty("ext_ids")
    private Map<String, String> extIds;

    @JsonProperty("segments")
    private List<String> segments;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("age")
    private int age;

    public enum Gender {
        MALE,
        FEMALE
    }
}
