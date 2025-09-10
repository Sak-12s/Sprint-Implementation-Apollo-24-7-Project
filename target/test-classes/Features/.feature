@bmi
Feature: Body Mass Index Calculation

Scenario: Verification of successful Body Mass Index Calculation

When the user click on View ALL in the Blogs and Articles section
When the user clicks on Health Tools
When the user clicks on Calculate under Body Mass Index
When the user selects the gender as "<bmigender>" and height as "<Underheight>" and weight as "<Underweight>"
Then verify Underweight is displayed
When the user selects the gender as "<bmigender>" and height as "<normalheight>" and weight as "<normalweight>"
Then verify Normal is displayed
When the user selects the gender as "<bmigender>" and height as "<overheight>" and weight as "<overweight>"
Then verify Overweight is displayed
When the user selects the gender as "<bmigender>" and height as "<obeseheight>" and weight as "<obeseweight>"
Then verify Obese is displayed
When the user selects the gender as "<bmigender>" and height as "<decimalheight>" and weight as "<decimalweight>"
Then verify BMI is displayed accurately
@Ignore
Scenario: Verification of failed Body Mass Index Calculation
When the user clicks on Calculate under Body Mass Index
When the user selects the gender as "<bmigender>" and height as "<height>" and weight as "<negativeweight>"
Then no BMI calculated
When the user selects the gender as "<bmigender>" and height as "<zeroheight>" and weight as "<weight>"
Then Invalid height error message is shown
When the user selects the next icon without selecting a gender
Then error message prompting user to enter values is shown