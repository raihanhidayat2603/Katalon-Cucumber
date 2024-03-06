@Logout
Feature: Log Out

  @Logout
  Scenario: Log Out
    Given User di halaman inventory
    When User klik sidebar
    And user klik button Logout
    Then sistem menampilkan halaman login