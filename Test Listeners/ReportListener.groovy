import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import report.ReportManager
import com.aventstack.extentreports.Status
import report.ScreenshotManager
import report.SuiteManager
import report.DashboardManager
import report.LogManager
import report.EnvironmentManager


class ReportListener {
	
	@BeforeTestSuite
	
	def beforeSuite(TestSuiteContext context){
	
        SuiteManager.startSuite()	
		LogManager.initialize()
		
		LogManager.info("Execution Started")
	}
	
	 @BeforeTestCase
    def beforeTestCase(TestCaseContext context) {

		DashboardManager.total++
		
        ReportManager.startTest(context.getTestCaseId())

    }

    @AfterTestCase
    def afterTestCase(TestCaseContext context) {

        if (context.getTestCaseStatus().equalsIgnoreCase("PASSED")) {

			DashboardManager.passed++
            ReportManager.getTest().log(Status.PASS, "Test Passed")

        }
        else {
			DashboardManager.failed++
			
            String image = ScreenshotManager.capture(context.getTestCaseId())

    ReportManager.getTest().fail(context.getMessage())

    if(context.getMessage()!=null){

        ReportManager.getTest().fail(
            "<details><summary><b>Exception Details</b></summary>"
            + context.getMessage()
            + "</details>"
        )

    }

    ReportManager.getTest().addScreenCaptureFromPath(image)

        }
		
		long duration = ReportManager.stopTimer()
		
		ReportManager.getTest().info(
				"Execution Time : " +
				duration +
				" ms")

    }

    @AfterTestSuite
    def afterSuite(TestSuiteContext context) {

		println "========== AFTER SUITE =========="

    SuiteManager.endSuite()

    ReportManager.flush()

    try {

        EnvironmentManager.createEnvironmentFile()

    }
    catch(Exception e){

        e.printStackTrace()

    }

    }
}