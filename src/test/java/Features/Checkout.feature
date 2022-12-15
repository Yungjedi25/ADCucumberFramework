Feature: Checkout process

  @E2ETest
  Scenario: Purchase confirmation
    Given I have a product in my cart
    When I complete the checkout process
    Then I am presented with a purchase confirmation page for my order