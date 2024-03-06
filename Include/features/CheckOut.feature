@CheckOut
Feature: Check Out

  @CheckOut
  Scenario: Check Out Barang
    Given User klik Add To Cart
    When User masuk ke menu Cart dan klik Checkout
    And user input information
    And user klik button Finish
    Then sistem menampilkan informasi 'Thank you for your order!'