Feature: API Endpoints
  Scenario: Successful GET request on /info
    When I send a GET request to /info
    Then the response status should be 200
    And the server should respond with a application/json
    And the json should contain a name, a description, and a version

 Scenario: Successful GET request on /health
   When I send a GET request to /health
   Then the response status should be 200
   And the server should respond with a application/json
   And the json should contain a status

 Scenario: Successful POST request on /account
   When I post account details to /account
   Then the response status should be 201
   And the server should respond with a application/json
   And the json should contain a user_id, username, password, email, created_on, last_login