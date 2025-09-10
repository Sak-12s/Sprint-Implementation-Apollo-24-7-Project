@login
Feature: Verification of User Log in
@Ignore
Scenario: Verification of login failure with invalid inputs
  Given the user is on the home page
  When the user clicks on login icon
  When the user enters invalid mobile number as "<invalid_mobile_no>"
  Then an error message is displayed "Invalid mobile number"
  Given the user is on the home page
  When the user clicks on login icon
  And the user enters valid mobile number as "<mobile_no>"
  And the user enters invalid otp
  Then an error message is displayed "Invalid OTP"
  
Scenario: Verification of successful user login with valid inputs
Given the user is on the home page
When the user clicks on login icon
When the user enters valid mobile number as "<mobile_no>"
When the user enters valid otp
Then the user is logged in