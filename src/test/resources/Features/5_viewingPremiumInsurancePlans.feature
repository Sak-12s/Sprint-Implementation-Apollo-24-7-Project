Feature: Viewing Premium Plans for Insurance

Scenario: Verification of failure in viewing premium insurance plans for user location
Given the user clicks on Buy Insurance
When the user clicks on location
When the user enters invalid pincode as "<invalidpincode>" in the location
When the user enters negative value as "<negativepincode>" for pincode in the location
When the user enters zero value as "<zeropincode>" for pincode in the location

Scenario: Verification of viewing premium insurance plans for user location successfully

When the user enters valid value as "<validpincode>" for the pincode in the location
Then the user view the plans
