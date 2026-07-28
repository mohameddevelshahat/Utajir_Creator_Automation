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
import report.ReportManager

public class ReportMetadata {

	static void set(Map data) {
		
				if(data.module)
					ReportManager.getTest().info("<b>Module :</b> " + data.module)
		
				if(data.feature)
					ReportManager.getTest().info("<b>Feature :</b> " + data.feature)
		
				if(data.story)
					ReportManager.getTest().info("<b>Story :</b> " + data.story)
		
				if(data.priority)
					ReportManager.getTest().info("<b>Priority :</b> " + data.priority)
		
				if(data.severity)
					ReportManager.getTest().info("<b>Severity :</b> " + data.severity)
		
				if(data.requirement)
					ReportManager.getTest().info("<b>Requirement :</b> " + data.requirement)
		
			}
}
