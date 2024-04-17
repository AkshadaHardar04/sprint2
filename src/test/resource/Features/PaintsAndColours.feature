
Feature: Working with Paints and Colours on Asian Paints

#Background
  Background: 
    Given user is on the homepage of Asian Paints website and hover over the Paints and Colors menu

#This scenario is for checking the add to product in cart functionality.
  @AddToCart
  Scenario: User add colour shades in cart
    When click on the Colour Catalogue option
    And scroll down the page to locate Grey button
    And click on the Grey button
    And scroll down the page to view Grey colours
    And click on the White Gold shade
    And click on the Know More button
    And enter the pincode
    And click on the ADD TO CART button
    Then the message will be displayed

#This scenario is for checking if the images are shown according to the living room filter.
  @Filter
  Scenario: User filters textures by selecting living room option
    When click on Interior Texture from the dropdown
    And scroll down to the View Textures button
    And click on View Textures button
    And click on Living Room from the room type options
    Then user should see images of interior textures filtered for the living room

#This scenario is for checking the process of locating stores in the specified city.
  @LocateAStore
  Scenario: Locating a store for interior texture paint in the kitchen section
    When click on Interior Texture from the dropdown
    And scroll down to the View Textures button
    And click on View Textures button
    And scroll down to the Kitchen button
    And click on the Kitchen button
    And scroll down to the Locator button
    And Enter the city "<name>" in the search field
      | Mumbai |
    And click on Locator button
    Then it should locate the stores in the specified city

# This scenario is for checking the expert recommendation page with valid credentials.
  @Valid
  Scenario Outline: Navigating to expert recommendation page using Paint Budget Calculator
    When click on Paints Budget Calculator
    And click on Fresh Painting radio button
    And click on interior radio button
    And enter <carpet_area> as the carpet area
    And click on Calculate Now button
    And Enter the details <uname>,<email>,<mobile-no>,<pincode>
    And click on get an estimate button
    Then user should be redirected to the Our Expert Recommendation page

    Examples: 
      | carpet_area | uname    | email             | mobile-no  | pincode |
      |         101 | Akshada | akshada@gmail.com | 9345267812 |  123456 |
  
#This scenario is for checking the expert recommendation page with invalid credentials.   
   @Invalid
   Scenario Outline: Navigating to expert recommendation page using Paint Budget Calculator
    When click on Paints Budget Calculator
    And click on Fresh Painting radio button
    And click on interior radio button
    And enter <carpet_area> as the carpet area
    And click on Calculate Now button
    And Enter the details <uname>,<email>,<mobile-no>,<pincode>
    And click on get an estimate button
    Then the error message will be displayed

    Examples: 
      | carpet_area | uname    | email             | mobile-no  | pincode |
      |         101 | Akshada | akshada@gmail.com | 934526781 |  123456 |

#This scenario is for checking whether the user can see shades of purple and pink colors after click on the purples and pinks option.
  @VerifyColour
  Scenario: Verify it will show shades of purple and pinks colour
    When user click on the Exterior Texture
    And user attempt to click on the purples and pinks option
    Then user should able to see the shades of purple and pinks colour
