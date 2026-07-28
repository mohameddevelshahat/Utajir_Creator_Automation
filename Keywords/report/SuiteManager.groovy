package report

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
import java.text.SimpleDateFormat


public class SuiteManager {

	private static long suiteStartTime
	
		private static String suiteStart
	
		private static String suiteEnd
	
		static void startSuite() {
	
			suiteStartTime = System.currentTimeMillis()
	
			suiteStart = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss")
					.format(new Date())
	
		}
	
		static void endSuite() {
	
			suiteEnd = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss")
					.format(new Date())
	
		}
	
		static String getStartTime() {
	
			return suiteStart
	
		}
	
		static String getEndTime() {
	
			return suiteEnd
	
		}
	
		static String getExecutionTime() {
	
			long duration =
					System.currentTimeMillis()
					- suiteStartTime
	
			long hours = duration / 3600000
	
			long minutes =
					(duration % 3600000) / 60000
	
			long seconds =
					(duration % 60000) / 1000
	
			return String.format(
					"%02d:%02d:%02d",
					hours,
					minutes,
					seconds)
	
		}
}
