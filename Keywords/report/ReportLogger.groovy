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
import com.aventstack.extentreports.Status
import report.LogManager
public class ReportLogger {
	
	static void info(String message) {
		
		if(ReportManager.getNode()!=null){
			
					ReportManager.getNode().info(message)
					LogManager.info(message)
			
				}else{
			
					ReportManager.getTest().info(message)
					LogManager.info(message)
			
				}
			
	}

	static void pass(String message) {
		if(ReportManager.getNode()!=null){

        ReportManager.getNode().pass(message)
		LogManager.pass(message)

    }else{

        ReportManager.getTest().pass(message)
		LogManager.pass(message)

    }
	}

	static void fail(String message) {
		if(ReportManager.getNode()!=null){

        ReportManager.getNode().fail(message)
		LogManager.fail(message)

    }else{

        ReportManager.getTest().fail(message)
		LogManager.fail(message)

    }
	}

	static void warning(String message) {
		ReportManager.getTest().log(Status.WARNING, message)
		LogManager.warning(message)
	}

	static void skip(String message) {
		ReportManager.getTest().log(Status.SKIP, message)
	}
	
	static void metadata(String title, String value){
			ReportManager.getTest().info("<b>"+title+":</b> "+value)
	}

}
