package edu.citadel.main;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.springframework.test.util.AssertionErrors.*;


public class StepDefinitions extends SpringIntegrationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @When("^I post account details to (.+)$")
    public void createAcc(String endpoint) {
        executePost(buildURL(endpoint),
                        """
                            {
                              "username" : "testUser",
                              "password" : "password",
                              "email" : "test@email.example.com"
                            }
                        """
                );
    }

    @When("^I send a GET request to (.+)$")
    public void sendGetRequestTo(String endpoint) {
        executeGet(buildURL(endpoint));
    }

    @Then("the response status should be {int}")
    public void verifyResponseStatus(int expectedStatus) throws AssertionError {
        int actualStatus = response.getStatusCode().value();

        assertEquals("Expected " + expectedStatus + " but got " + actualStatus,
                expectedStatus, actualStatus);
    }

    @Then("^the server should respond with a (.+)$")
    public void verifyResponseType(String expectedType) {
        String actualType = Objects.requireNonNull(
                response.getHeaders().getContentType()).toString();

        assertTrue("Expected " + expectedType + "response type, got "
                        + actualType,
                actualType.equalsIgnoreCase(expectedType)
        );
    }


    @Then("^the json should contain a (.+)$")
    public void jsonContainsKeys(String keys) {
        // grab the keys, split off ', ' and any attached
        // whitespace, along with throwing out grammar fluff
        String[] expectedKeys = keys.split("\\s*((,|(and)|a)+\\s+)+");

        // Probably overcomplicated but I need the regex practice anyway.

        // read the JSON
        JsonNode jsonBody;

        try {
            jsonBody = objectMapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            fail("Server returned invalid JSON. " + e.getMessage());
            return;
        }


////      For testing regex delimiter
//        for (String expectedKey : expectedKeys) {
//            System.out.println("\"" + expectedKey +"\"");
//        }


        for (String expectedKey : expectedKeys) {
            assertTrue("Returned JSON does not contain " + expectedKey + ".",
                    jsonBody.has(expectedKey)
            );
        }
    }

}
