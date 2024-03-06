@login
Feature: Login

  @LoginStandard
  Scenario: Login Standard User
    Given user berada di halaman Login
    When user memasukan Username dan Password Standard User
    And user klik button Login
    Then user berada di halaman Dashboard
    
  @LoginLockedOut
  Scenario: Login Locked Out User
    Given user berada di halaman Login
    When user memasukan Username dan Password Locked Out User
    And user klik button Login
    Then web menampilkan alert user sudah di kunci

    @LoginProblem
  Scenario: Login Problem User
    Given user berada di halaman Login
    When user memasukan Username dan Password Problem User
    And user klik button Login
    Then user berada di halaman Dashboard
    
    @LoginPerfomanceGlitch
  Scenario: Login Perfomance Glitch User
    Given user berada di halaman Login
    When user memasukan Username dan Password Perfomance Glitch User
    And user klik button Login
    Then user berada di halaman Dashboard
    
    @LoginWrongUsername
  Scenario: Login Wrong Username
    Given user berada di halaman Login
    When user memasukan Username yang salah dan Password benar
    And user klik button Login
    Then web menampilkan alert username dan password tidak sesuai
    
    @LoginWrongPassword
  Scenario: Login Perfomance Glitch User
    Given user berada di halaman Login
    When user memasukan Username yang benar dan Password salah
    And user klik button Login
    Then web menampilkan alert username dan password tidak sesuai
    
    @LoginOnlyUsername
  Scenario: Login Only Username
    Given user berada di halaman Login
    When user memasukan Username saja
    And user klik button Login
    Then web menampilkan alert Password is required
    
    @LoginOnlyPassword
  Scenario: Login Only Password
    Given user berada di halaman Login
    When user memasukan Password Saja
    And user klik button Login
    Then web menampilkan alert Username is required
  