@FunctionalTest
Feature: Get BMI Details
  
Scenario Outline: Find BMI value of given data
    Given User is on BMI calculator home page
    Then validate Home tittle page
    When click on BMI Calculator
    Then validate BMI calculaor tittle page
    And Enter the age <Age> 
    And Enter the height <Height>
    And Enter the weight <Weight>
    When Tap on Calculate BMI
    Then Capture the BMI Result value and Print it
    And close browser
      
    Examples: 
      | Age | Height | Weight |
      | 10  |   127  |   40   |
      | 30  |   156  |   70   |
      | 25  |   152  |   55   |
      | 20  |   160  |   45   |
      | 35  |   160  |   70   |
      
 
      

