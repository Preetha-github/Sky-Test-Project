@Skyshop
Feature: This feature will make sure that the shop page is navigable and usable.

@Homepage
Scenario: User navigates to shop page
 Given I am on the home page
 And I accept cookies
 When I navigate to ‘Products & Packages’
 Then the user should be on the ‘https://www.sky.com/shop/’ page

@ShoppageTiles
Scenario: User sees tiles on the shop page
 Given I am on the home page
 And I accept cookies
 When I navigate to ‘Products & Packages’
 Then I should see tiles with text in it 
 
@Offers
Scenario: User sees a list of offers on the latest offers page
 Given I am on the home page
 And I accept cookies
 When I navigate to ‘Products & Packages’
 And I click on ‘Our latest Offers’ section
 Then I see a list of offers with a price to it
