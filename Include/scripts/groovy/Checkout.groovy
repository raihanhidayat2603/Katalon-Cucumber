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



class Checkout {

	String firstName = 'Raihan'
	String lastName = 'Hidayat'
	String postalCode = '28912'
	
	@Given("User klik Add To Cart")
	def AddToCart() {
		WebUI.navigateToUrl(GlobalVariable.urlInventory)
		
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[@class='title' and text()='Products']"), 5)
		
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[@class='title' and text()='Products']"), 1, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@id='add-to-cart-sauce-labs-backpack']"))
		WebUI.delay(2)
		
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@id='add-to-cart-sauce-labs-bike-light']"))
		WebUI.delay(2)
	}

	@When("User masuk ke menu Cart dan klik Checkout")
	def MenuCartAndClickCheckout() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//a[@class="shopping_cart_link"]'))
		WebUI.delay(2)
		
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[@id="checkout"]'))
		WebUI.delay(2)
	}

	@And("user input information")
	def inputInformation() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="first-name"]'), firstName)
		WebUI.delay(2)
		
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="last-name"]'), lastName)
		WebUI.delay(2)
		
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="postal-code"]'), postalCode)
		WebUI.delay(2)
		
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id="continue"]'))
		WebUI.delay(2)
	}
	
	@And("user klik button Finish")
	def ClickFinish() {
		
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[@id="finish"]'))
		WebUI.delay(2)
		
	}

	@Then("sistem menampilkan informasi 'Thank you for your order!'")
	def CheckInformasiThanYouk() {
		WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@class='complete-header' and text()[contains(.,'Thank you for your order!')]]"), 5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@class='complete-header' and text()[contains(.,'Thank you for your order!')]]"), 1, FailureHandling.STOP_ON_FAILURE)
	}
}