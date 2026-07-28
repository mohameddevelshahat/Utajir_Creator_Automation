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


public class LogManager {

	private static File logFile
	
		static void initialize() {
	
			String path =
					ReportFolderManager.getReportFolder() +
					"/execution.log"
	
			logFile = new File(path)
	
			if (!logFile.exists()) {
				logFile.createNewFile()
			}
	
		}
	
		static void info(String message) {
	
			write("INFO", message)
	
		}
	
		static void pass(String message) {
	
			write("PASS", message)
	
		}
	
		static void fail(String message) {
	
			write("FAIL", message)
	
		}
	
		static void warning(String message) {
	
			write("WARN", message)
	
		}
	
		private static void write(String level,String message) {
	
			String time =
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date())
	
			logFile.append(
					"[" + time + "] "
					+ "[" + level + "] "
					+ message
					+ System.lineSeparator()
			)
	
		}
}
