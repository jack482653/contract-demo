package com.example.biddingengine.external;

import com.example.biddingengine.model.Audience;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example:dmp:+:stubs:10001")
@ActiveProfiles("test")
class AudienceApiTest {

    @Autowired
    private AudienceApi audienceApi;

    @Test
    public void getAudience_ShouldReturnAudience_WhenAudienceExist() throws IOException, InterruptedException {
        Audience audience = audienceApi.getAudience("c8937bbe-bfbf-4200-90d5-d23313d6ac4c");

        assertThat(audience).isNotNull();
    }

    @Test
    public void getAudience_ShouldReturnNull_WhenAudienceNotExist() throws IOException, InterruptedException {
        Audience audience = audienceApi.getAudience("146eca28-290a-485b-8718-e0b96128b041");

        assertThat(audience).isNull();
    }
}