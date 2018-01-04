Feature: checking that the opencart home page has all expected functionalities

  Background:
  Given User should be on opencart layout2 homepage

  Scenario: User wants to Register to buy the product
    When    User clicks the Register link
    And     User enters the Firstname,Lastname,Email,Telephone,Password and ConfirmPassword
    And     User clicks the continue button
    Then    User can successfully create an opencart account with text "Your Account Has Been Created!"
    And     User clicks the Logout button
    And     User should Logout with text "Account Logout"
    And     User clicks the continue button
    And     User should navigate to home page


  Scenario: User try to login with valid login credentious/details and logout
    When    User clicks the Login link
    And     User enters the Email address and password
    And     User clicks the Login button
    Then    User can login successfully
    And     User clicks the Logout button
    And     User should Logout with text "Account Logout"
    And     User clicks the continue button
    And     User should navigate to home page

  Scenario: User wants to view the products in selected currency value
    When    User mouseover to currency dropdown
    And     User selects the Pound sterling
    Then    User can succefully view the products in pounds

  Scenario: User wants to change the language
    When    User mouseover to language dropdown
    And     User selects the English language
    Then    User can view the products in selected language

  Scenario Outline: User wants to search items from searchbar
    When            User enters the item  <"product">
    And             User clicks the search button
    Then            User can successfully view the item
   Examples:
     | product           |
     | Corem ipsum dolor |
     | Drutick lanaeger  |
     | Hofficia chicken  |

   Scenario:  User wants to add the products to cart
     When     User clicks the All Categories
     And      User clicks the Gifts & Toys
     And      User can select an perticular item from displayed item
     And      User selects the quantity
     And      User clicks the Add to Cart button
     Then     User can add the item in cart with text "Success"

   Scenario: User wants to search an item from categories
     When    User clicks the Categories from side popup bar
     And     User  clicks the Accessories
     Then    User can view the items

   Scenario: User wants to select the Features on homepage
     When    User mouseover to Features
     Then    User can view the items according to Feature

   Scenario: User clicks  the About us page
     When    User mouseover to Pages
     And     User clicks the About Us page
     Then    User can view the About Us page with text "Welcome To shop"

   Scenario:  User wants to signup for Newsletter
     When     User enters the email address
     And      User clicks the Subscribe button
     Then     User can get the message "Subscription Successful"

   Scenario:  User wants to Go To Top page from bottom of the home page
     When     User clicks the Go To Top button from side popup bar
     Then     User can successfully view the front home page

   Scenario:  User wants to view the recent products
     When     User clicks the Recent view button from side popup bar
     Then     User can view the Recent products
