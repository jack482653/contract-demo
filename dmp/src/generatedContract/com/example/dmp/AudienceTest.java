package com.example.dmp;

import com.example.dmp.AudienceBase;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;

import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;
import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@SuppressWarnings("rawtypes")
public class AudienceTest extends AudienceBase {

	@Test
	public void validate_should_return_audience() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();


		// when:
			ResponseOptions response = given().spec(request)
					.get("/rest/audiences/c8937bbe-bfbf-4200-90d5-d23313d6ac4c");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);

		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['audience_id']").isEqualTo("c8937bbe-bfbf-4200-90d5-d23313d6ac4c");
			assertThatJson(parsedJson).field("['ext_ids']").field("['doubleclick']").matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}");
			assertThatJson(parsedJson).array("['segments']").arrayField().isEqualTo("6ebc39d5-e611-4e10-8b79-b487c4bd5951").value();
			assertThatJson(parsedJson).array("['segments']").arrayField().isEqualTo("b132054f-a7f3-49b1-b278-f5231c02e16c").value();
			assertThatJson(parsedJson).array("['segments']").arrayField().isEqualTo("ebc64f06-7de2-4247-b440-01b54083e1ae").value();
			assertThatJson(parsedJson).field("['gender']").matches("^MALE$|^FEMALE$");
			assertThatJson(parsedJson).field("['age']").matches("([1-9]\\d*)");
	}

	@Test
	public void validate_should_return_audience_not_found() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();


		// when:
			ResponseOptions response = given().spec(request)
					.get("/rest/audiences/146eca28-290a-485b-8718-e0b96128b041");

		// then:
			assertThat(response.statusCode()).isEqualTo(404);
	}

}
