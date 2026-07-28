package framework

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import report.ReportLogger

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.annotation.Keyword
import org.openqa.selenium.Cookie
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys
import java.io.File
import java.util.Arrays

import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper


public class UIActions {

	@Keyword
static void click(TestObject obj) {

    click(obj, "Click Element")

}

@Keyword
static void click(TestObject obj, String stepName) {

    try {

        ReportLogger.info(stepName)

        WebUI.click(obj)

        ReportLogger.pass(stepName)

    }

    catch (Exception ex) {

        ReportLogger.warning(
            "Normal Click Failed... Trying JavaScript Click"
        )

        try {

            WebElement element =
                    WebUiCommonHelper.findWebElement(obj,10)

            WebUI.executeJavaScript(
                "arguments[0].click();",
                Arrays.asList(element)
            )

            ReportLogger.pass(
                stepName + " (JavaScript Click)"
            )

        }

        catch(Exception e){

            ReportLogger.fail(stepName)

            throw e

        }

    }

}

@Keyword
static void jsClick(TestObject obj){

	jsClick(obj,"JavaScript Click")

}

@Keyword
static void jsClick(TestObject obj,String stepName){

	try{

		ReportLogger.info(stepName)

		WebElement element = WebUiCommonHelper.findWebElement(obj,10)

		WebUI.executeJavaScript(

			"arguments[0].click();",

			Arrays.asList(element)

		)

		ReportLogger.pass(stepName + " - Passed")

	}catch(Exception e){

		ReportLogger.fail(stepName + " - Failed")

		throw e
	}

}
	
	@Keyword
static void openBrowser(String url) {

    openBrowser(url, "Open Browser")

}

@Keyword
static void openBrowser(String url, String stepName) {

    try {

        ReportLogger.info(stepName)

        WebUI.openBrowser(url)

        WebUI.maximizeWindow()

        ReportLogger.pass(stepName + " - Passed")

    } catch (Exception e) {

        ReportLogger.fail(stepName + " - Failed")

        throw e

    }

}

@Keyword
static void refresh() {

	refresh("Refresh Page")

}

@Keyword
static void refresh(String stepName) {

	try {

		ReportLogger.info(stepName)

		WebUI.refresh()

		ReportLogger.pass(stepName + " - Passed")

	} catch(Exception e) {

		ReportLogger.fail(stepName + " - Failed")

		throw e
	}
}
@Keyword
static void waitForPageLoad(int timeout) {

	waitForPageLoad(timeout, "Wait For Page Load")

}

@Keyword
static void waitForPageLoad(int timeout, String stepName) {

	try {

		ReportLogger.info(stepName)

		WebUI.waitForPageLoad(timeout)

		ReportLogger.pass(stepName + " - Passed")

	} catch(Exception e) {

		ReportLogger.fail(stepName + " - Failed")

		throw e
	}

}
@Keyword
static void scrollToElement(TestObject obj,int timeout) {

	scrollToElement(obj,timeout,"Scroll To Element")

}

@Keyword
static void scrollToElement(TestObject obj,int timeout,String stepName) {

	try {

		ReportLogger.info(stepName)

		WebUI.scrollToElement(obj, timeout)

		ReportLogger.pass(stepName + " - Passed")

	} catch(Exception e) {

		ReportLogger.fail(stepName + " - Failed")

		throw e
	}

}
@Keyword
static void waitForElementVisible(TestObject obj,int timeout){

	waitForElementVisible(obj,timeout,"Wait Element Visible")

}

@Keyword
static void waitForElementVisible(TestObject obj,int timeout,String stepName){

	try{

		ReportLogger.info(stepName)

		WebUI.waitForElementVisible(obj, timeout)

		ReportLogger.pass(stepName + " - Passed")

	}catch(Exception e){

		ReportLogger.fail(stepName + " - Failed")

		throw e
	}

}

@Keyword
static void verifyElementVisible(TestObject obj){

	verifyElementVisible(obj,"Verify Element Visible")

}

@Keyword
static void verifyElementVisible(TestObject obj,String stepName){

	try{

		ReportLogger.info(stepName)

		WebUI.verifyElementVisible(obj)

		ReportLogger.pass(stepName + " - Passed")

	}catch(Exception e){

		ReportLogger.fail(stepName + " - Failed")

		throw e
	}

}
	@Keyword
static void setText(TestObject obj, String value) {

    setText(obj, value, "Enter Text")

}

@Keyword
static void setEncryptedText(TestObject obj, String encryptedText) {

	setEncryptedText(obj, encryptedText, "Enter Encrypted Text")

}

@Keyword
static void setEncryptedText(TestObject obj, String encryptedText, String stepName) {

	try {

		ReportLogger.info(stepName)

		WebUI.setEncryptedText(obj, encryptedText)

		ReportLogger.pass(stepName + " - Passed")

	} catch (Exception e) {

		ReportLogger.fail(stepName + " - Failed")

		ReportLogger.fail(e.getMessage())

		throw e

	}

}

@Keyword
static void setText(TestObject obj, String value, String stepName) {

    try {

        ReportLogger.info(stepName)

        WebUI.setText(obj, value)

        ReportLogger.pass(stepName + " - Passed")

    } catch (Exception e) {

        ReportLogger.fail(stepName + " - Failed")

        throw e
    }

}
	@Keyword
static void verifyElementText(TestObject obj, String expected) {

    verifyElementText(obj, expected, "Verify Element Text")

}

@Keyword
static void verifyElementText(TestObject obj, String expected, String stepName) {

    try {

        ReportLogger.info(stepName)

        WebUI.verifyElementText(obj, expected)

        ReportLogger.pass(stepName + " - Passed")

    } catch (Exception e) {

        ReportLogger.fail(stepName + " - Failed")

        throw e
    }

}
	@Keyword
static void acceptAlert() {

    acceptAlert("Accept Alert")

}

@Keyword
static void acceptAlert(String stepName) {

    try {

        ReportLogger.info(stepName)

        WebUI.acceptAlert()

        ReportLogger.pass(stepName + " - Passed")

    } catch (Exception e) {

        ReportLogger.fail(stepName + " - Failed")

        throw e

    }

}
	@Keyword
static void closeBrowser() {

    closeBrowser("Close Browser")

}

@Keyword
static void closeBrowser(String stepName) {

    try {

        ReportLogger.info(stepName)

        WebUI.closeBrowser()

        ReportLogger.pass(stepName + " - Passed")

    } catch (Exception e) {

        ReportLogger.fail(stepName + " - Failed")

        throw e

    }

}
	@Keyword
static void saveCookies(String fileName) {

    saveCookies(fileName, "Save Cookies")

}

@Keyword
static void sendKeys(TestObject obj, String keys) {

	sendKeys(obj, keys, "Send Keys")

}

@Keyword
static void sendKeys(TestObject obj, String keys, String stepName) {

	try {

		ReportLogger.info(stepName)

		WebUI.sendKeys(obj, keys)

		ReportLogger.pass(stepName + " - Passed")

	} catch (Exception e) {

		ReportLogger.fail(stepName + " - Failed")

		ReportLogger.fail(e.getMessage())

		throw e
	}

}

@Keyword
static void saveCookies(String fileName, String stepName) {

    try {

        ReportLogger.info(stepName)

        def cookies = DriverFactory.getWebDriver().manage().getCookies()

        File file = new File(fileName)

        file.withObjectOutputStream { out ->
            out.writeObject(cookies)
        }

        ReportLogger.pass(stepName + " - Passed")

    } catch (Exception e) {

        ReportLogger.fail(stepName + " - Failed")

        throw e
    }

}

@Keyword
static void loadCookies(String fileName){

	loadCookies(fileName,"Load Cookies")

}

@Keyword
static void loadCookies(String fileName,String stepName){

	try{

		ReportLogger.info(stepName)

		File file = new File(fileName)

		def cookies = file.withObjectInputStream{

			input ->

			input.readObject()

		}

		def driver = DriverFactory.getWebDriver()

		cookies.each{

			cookie ->

			driver.manage().addCookie(cookie)

		}

		ReportLogger.pass(stepName + " - Passed")

	}catch(Exception e){

		ReportLogger.fail(stepName + " - Failed")

		throw e

	}

}
	
}
