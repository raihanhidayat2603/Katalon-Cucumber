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



class Logout {
	@Given("User di halaman inventory")
	def halamanInventoryToLogout() {
		WebUI.navigateToUrl(GlobalVariable.urlInventory)
		WebUI.delay(2)
		
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[@class='title' and text()='Products']"), 5)
		
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[@class='title' and text()='Products']"), 1, FailureHandling.STOP_ON_FAILURE)
		
	}

	@When("User klik sidebar")
	def klikSidebarToLogout() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[@id="react-burger-menu-btn"]'))
		WebUI.delay(2)
	}

	@And("user klik button Logout")
	def klikLogoutToLogout() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//a[@id="logout_sidebar_link"]'))
		WebUI.delay(2)
	}

	@Then("sistem menampilkan halaman login")
	def loginAfterToLogout() {
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id='user-name']"), 5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id='user-name']"), 1, FailureHandling.STOP_ON_FAILURE)
	}
}