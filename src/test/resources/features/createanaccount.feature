@login
  Feature: Create an account

    Scenario: create an account on crowdstreet
      Given User is on the login page
      When User clicks Create an Account button
      Then User is taken to new page where has to enter First Name
      And User has to enter Last Name
      And User has to enter email
      And User has to enter password
      And User needs to confirm password
      And User needs to answer if he is accredited investor
      And User has to accept terms and conditions by clicking on the button
      Then User has to click create account button
      And User needs to click ok on captcha





