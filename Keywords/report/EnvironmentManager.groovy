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

public class EnvironmentManager {

	static void createEnvironmentFile() {
		
				String folder = ExtentManager.getReportFolder()
		
				File envFile = new File(folder + "/Environment.txt")
		
				envFile.withWriter("UTF-8") { writer ->
		
					writer.println("========== EXECUTION ENVIRONMENT ==========")
					writer.println()
		
					writer.println("Project        : " + MetadataManager.project)
					writer.println("Tester         : " + MetadataManager.tester)
					writer.println("Framework      : " + MetadataManager.framework)
					writer.println("Language       : " + MetadataManager.language)
		
					writer.println()
		
					writer.println("Browser        : " + MetadataManager.browser)
					writer.println("Environment    : " + MetadataManager.environment)
					writer.println("Execution      : " + MetadataManager.execution)
		
					writer.println()
		
					writer.println("Operating System : " + System.getProperty("os.name"))
					writer.println("OS Version       : " + System.getProperty("os.version"))
					writer.println("Java Version     : " + System.getProperty("java.version"))
					writer.println("User             : " + System.getProperty("user.name"))
		
					writer.println()
		
					writer.println("Katalon Version : " +System.getProperty("katalon.version","11"))
		
					writer.println()
		
					writer.println("Suite Started : " + SuiteManager.getStartTime())
					writer.println("Suite Ended   : " + SuiteManager.getEndTime())
					writer.println("Duration      : " + SuiteManager.getExecutionTime())
		
					writer.println()
		
					writer.println("Generated : " +
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
		
				}
		
			}
}
