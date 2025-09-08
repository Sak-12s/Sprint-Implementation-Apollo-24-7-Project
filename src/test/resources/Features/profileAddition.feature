Feature: Addition of new Profile
Scenario: Verification of successful profile addition

Given the user is on the home page
When the user clicks on login icon
When the user clicks on the manage family members
When the user clicks on add new profile
When the user enters the first name as "<firstname>"
When the user enters the last name as "<lastname>"
When the user enters the dob as "<dob>"
When the user choose the gender as "<gender>"
When the user choose the relation as "<relation>"
When the user clicks on save and ok button
Then the new profile is added successfully