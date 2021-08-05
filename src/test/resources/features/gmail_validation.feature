@Test
Feature: Gmail Functionality

  Background: 
    Given user is on the gmail website

  Scenario: Verify the compose button in gmail
    When user login to applicaton
    Then verify the compose button is present

  Scenario: Verify user is able to send an email
    When user clicks compose button
    And user enters in subject "Incubyte"
    And user enters in body "Automation QA test for Incubyte"
    Then on clicking send button pop up should be displayed with message "Message sent."
