Feature: BMI Calculator Testing
Background:
Given user opens BMI website


Scenario: TC01 Verify gender accepts Female
When user selects gender "Female"
And user enters weight "69"
And user enters height "169"
And user clicks calculate
Then BMI result should be displayed


Scenario: TC02 Verify gender accepts Male
When user selects gender "Male"
And user enters weight "69"
And user enters height "169"
And user clicks calculate
Then BMI result should be displayed


Scenario: TC03 Verify gender accepts Other
When user selects gender "Other"
And user enters weight "69"
And user enters height "169"
And user clicks calculate
Then BMI result should be displayed


Scenario: TC04 Verify gender rejects Prefer not to say
When user selects gender "Prefer not to say"
Then gender should not be accepted


Scenario: TC05 Verify weight placeholder shows kg in Metric
When user selects unit "Metric"
Then weight placeholder should show "kg"


Scenario: TC06 Verify height placeholder shows cm in Metric
When user selects unit "Metric"
Then height placeholder should show "cm"


Scenario: TC07 Verify weight placeholder shows lb in Imperial
When user selects unit "Imperial"
Then weight placeholder should show "lb"


Scenario: TC08 Verify height placeholder shows in in Imperial
When user selects unit "Imperial"
Then height placeholder should show "in"


Scenario: TC09 Verify BMI calculation with Metric values
When user selects unit "Metric"
And user enters weight "69"
And user enters height "169"
And user clicks calculate
Then BMI result should be displayed


Scenario: TC10 Verify BMI calculation with Imperial values
When user selects unit "Imperial"
And user enters weight "150"
And user enters height "65"
And user clicks calculate
Then BMI result should be displayed
