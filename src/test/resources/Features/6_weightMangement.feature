Feature: Accessing Weight Management
Scenario: Verification of failed BMI Calculation
Given the user selects on weight management in home page
When the user clicks on BMI meter
When the user clicks on submit without any input
When the user enters negative height as "<negativeheight>" and weight as "<weight>"
When the user enters height as "<height>" and zero weight as "<zeroweight>"
When the user enters excessively large height as "<largeheight>" and excessively large weight as "<largeweight>"

Scenario: Verification of successful BMI Calculation
When the user enters valid height as "<validheight>" and valid weight as "<validweight>"
When the user enters decimal height as "<decimalheight>" and decimal weight as "<decimalweight>"