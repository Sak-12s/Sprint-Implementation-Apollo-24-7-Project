Feature: Verification of User Log in
Scenario: Verification of successful user login with mobile number
Given the user is on the home page
When the user clicks on login icon
When the user enters valid mobile number
When the user enters valid otp
Then the user is logged in
