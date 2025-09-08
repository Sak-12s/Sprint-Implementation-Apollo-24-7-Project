Feature: Addition of new Profile

Scenario: Verifivation of entering an invalid first name prevents profile addition
Given the user is on the home page
When the user clicks on login icon
When the user clicks on the manage family members
When the user clicks on add new profile
When the user enters the invalid first name as "<invalidfirstname>"


Scenario: Verifivation of entering an invalid last name prevents profile addition
When the user clicks on add new profile
When the user enters the invalid last name as "<invalidlasttname>"

Scenario: Verifivation of entering an invalid dob prevents profile addition
When the user clicks on add new profile
When the user enters the invalid dob as "<invaliddob>"

Scenario: Verifivation of entering an invalid email prevents profile addition
When the user clicks on add new profile
When the user enters the invalid email as "<invalidemail>"

Scenario: Verification of successful profile addition with all valid inputs excluding email 

When the user clicks on add new profile
When the user enters the first name as "<firstname>"
When the user enters the last name as "<lastname>"
When the user enters the dob as "<dob>"
When the user choose the gender as "<gender>"
When the user choose the relation as "<relation>"
When the user clicks on save and ok button
Then the new profile is added successfully


Scenario: Verification of successful profile addition with all valid inputs including email

When the user clicks on add new profile
When the user enters the first name as "<firstname>"
When the user enters the last name as "<lastname>"
When the user enters the dob as "<dob>"
When the user choose the gender as "<gender>"
When the user choose the relation as "<relation>"
When the user enters the email as "<email>"
When the user clicks on save and ok button
Then the new profile is added successfully

