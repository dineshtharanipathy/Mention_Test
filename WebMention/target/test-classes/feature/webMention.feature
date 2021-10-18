
Feature: The goal of this challenge is to automate a test scenario for the web application at web.mention.com


  Scenario: Automate Test Scenario of a Web Application
    Given User Opens webMention url
    And User Enters UserName
    And User Enters Password
    And User Click ConnectNow button
    Then User verifies the site loaded completely
    And User verifies an alert named Lenovo Thinkpad
    And User see a mention with content SB10F46467 Fit for:Lenovo Thinkpad
    Given User enter the keyword ifixit T520i in search field
    Then User see a mention with keyword Lenovo thinkpad T520i