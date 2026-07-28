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


public class StepLogger {
	private static int step = 1
	
		static void reset() {
			step = 1
		}
	
		static void logStep(String action,
							String object,
							String value,
							String status,
							long duration) {
	
			String html = """

        <table style='width:100%;border-collapse:collapse;font-size:13px;' border='1'>

            <tr style='background:#2E86C1;color:white'>
                <th colspan='2'>
                    STEP ${step}
                </th>
            </tr>

            <tr>
                <td width='25%'><b>Action</b></td>
                <td>${action}</td>
            </tr>

            <tr>
                <td><b>Object</b></td>
                <td>${object}</td>
            </tr>

            <tr>
                <td><b>Value</b></td>
                <td>${value}</td>
            </tr>

            <tr>
                <td><b>Duration</b></td>
                <td>${duration} ms</td>
            </tr>

            <tr>
                <td><b>Status</b></td>
                <td>${status}</td>
            </tr>

        </table>

        <br>

        """
	
			ReportManager.getTest().log(Status.INFO, html)
	
			step++
		}
	

}
