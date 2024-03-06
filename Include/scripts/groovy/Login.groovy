import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {

	String standard = 'standard_user';
	String lockedOut = 'locked_out_user';
	String problem = 'problem_user';
	String perfomanceGlitch = 'performance_glitch_user';
	String password = 'secret_sauce';

	@Given("user berada di halaman Login")
	def navigateToUrlWeb() {

		WebUI.enableSmartWait()

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl(GlobalVariable.url)
	}

	@When("user memasukan Username dan Password Standard User")
	def userInputUsernamePasswordStandardUser() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), standard)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), password)
	}

	@When("user memasukan Username dan Password Locked Out User")
	def userInputUsernamePasswordLockedOutUser() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), lockedOut)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), password)
	}

	@When("user memasukan Username dan Password Problem User")
	def userInputUsernamePasswordProblemUser() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), problem)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), password)
	}

	@When("user memasukan Username dan Password Perfomance Glitch User")
	def userInputUsernamePasswordPerformanceGlitchUser() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), perfomanceGlitch)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), password)
	}

	@When("user memasukan Username yang salah dan Password benar")
	def usernameSalahPasswordBenar() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), 'user')
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), password)
	}

	@When("user memasukan Username yang benar dan Password salah")
	def usernameBenarPasswordSalah() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), standard)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), 'password')
	}

	@When("user memasukan Username saja")
	def userInputUsernameSaja() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), standard)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), '')
	}

	@When("user memasukan Password saja")
	def userInputPasswordSaja() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="user-name"]'), '')
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]'), 'password')
	}

	@And("user klik button Login")
	def klikLogin() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="login-button"]'))
	}

	@Then("user berada di halaman Dashboard")
	def verifyDashboard() {
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@class='inventory_item_name ']"), 5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@class='inventory_item_name ']"), 1, FailureHandling.STOP_ON_FAILURE)
	}

	@Then("web menampilkan alert user sudah di kunci")
	def tampilAlertLockedOutUser() {
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Sorry, this user has been locked out.')]]"), 5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Sorry, this user has been locked out.')]]"), 1, FailureHandling.STOP_ON_FAILURE)
	}

	@Then("web menampilkan alert username dan password tidak sesuai")
	def tampilUsernamePasswordNotMatch() {
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Username and password do not match any user in this service')]]"), 5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Username and password do not match any user in this service')]]"), 1, FailureHandling.STOP_ON_FAILURE)
	}

	@Then("web menampilkan alert Username is required")
	def tampilAlertUsernameIsRequired() {
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Username is required')]]"), 5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Username is required')]]"), 1, FailureHandling.STOP_ON_FAILURE)
	}

	@Then("web menampilkan alert Password is required")
	def tampilAlertPasswordIsRequired() {
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Password is required')]]"), 5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[@data-test='error' and text()[contains(.,'Epic sadface: ')] and text()[contains(.,'Password is required')]]"), 1, FailureHandling.STOP_ON_FAILURE)
	}
}