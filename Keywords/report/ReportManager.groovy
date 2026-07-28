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
import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import java.text.SimpleDateFormat

public class ReportManager {
	
	private static ExtentReports extent

	
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>()
    private static ThreadLocal<Long> startTime = new ThreadLocal<>()
	
	private static long suiteStartTime
	
	private static ThreadLocal<ExtentTest> node = new ThreadLocal<>()
	
	private static ThreadLocal<ExtentTest> parent = new ThreadLocal<>()

    static void startTest(String testName) {

		println("===== START TEST =====")
    ExtentTest extentTest =
        getExtent().createTest(testName)

    // ضع الـ ExtentTest داخل ThreadLocal أولاً
    test.set(extentTest)

    // ثم أضف كل الـ Metadata
    getTest().assignAuthor("Mohamed Alshahat")

    getTest().assignDevice(System.getProperty("browser", "Chrome"))

    getTest().assignCategory("Regression")
    getTest().assignCategory("Web")
    getTest().assignCategory("Smoke")

    if (testName.contains("/")) {
        getTest().assignCategory(testName.split("/")[1])
    }

    startTimer()
    }

    static void startTimer() {
        startTime.set(System.currentTimeMillis())
    }

    static long stopTimer() {
        return System.currentTimeMillis() - startTime.get()
    }

    static ExtentTest getTest() {
        return test.get()
    }

    static void flush() {
    
		println("===== REPORT MANAGER FLUSH =====")
		ExtentTest dashboard = extent.createTest("Execution Summary")
		
			dashboard.info("Project : Utajir Creator")
		
			dashboard.info("Environment : QA")
		
			dashboard.info("Browser : " + System.getProperty("browser","Chrome"))
		
			dashboard.info("Executed By : Mohamed Alshahat")
				
			dashboard.pass("Passed : " + DashboardManager.passed)
		
			dashboard.fail("Failed : " + DashboardManager.failed)
		
			dashboard.skip("Skipped : " + DashboardManager.skipped)
		
			dashboard.info("Total : " + DashboardManager.total)
		
			dashboard.info(
				"Pass Rate : "
				+ String.format("%.2f", DashboardManager.getPassRate())
				+ "%"
			)
		
              getExtent().flush()
}

    // ===============================
    // Metadata Methods
    // ===============================

    static void assignAuthor(String author) {
        getTest().assignAuthor(author)
    }

    static void assignCategory(String category) {
        getTest().assignCategory(category)
    }

    static void assignDevice(String device) {
        getTest().assignDevice(device)
    }

	static void description(String description) {
		
			getTest().info("<b>Description:</b> " + description)
		
		}
		
		static void feature(String feature) {
		
			getTest().assignCategory(feature)
		
			getTest().info("<b>Feature:</b> " + feature)
		
		}
		
		static void module(String module) {
		
			getTest().info("<b>Module:</b> " + module)
		
		}
		
		static void requirement(String requirement) {
		
			getTest().info("<b>Requirement:</b> " + requirement)
		
		}
		
		static void priority(String priority) {
		
			getTest().info("<b>Priority:</b> " + priority)
		
		}
		
		static void severity(String severity) {
		
			getTest().info("<b>Severity:</b> " + severity)
		
		}
		
		static void story(String story) {
		
			getTest().info("<b>User Story:</b> " + story)
		
		}
		
		static void startSuite() {
			
				suiteStartTime = System.currentTimeMillis()
			
			}
			
			static String getExecutionTime() {
				
					long duration = System.currentTimeMillis() - suiteStartTime
				
					long seconds = duration / 1000
				
					long minutes = seconds / 60
				
					seconds %= 60
				
					return String.format("%02d min %02d sec", minutes, seconds)
				
				}
				static String getCurrentTime(){
					
						return new SimpleDateFormat(
							"yyyy-MM-dd hh:mm:ss a"
						).format(new Date())
					
					}
					
					static void createParent(String name){
						
							parent.set(getTest().createNode(name))
						
						}
						static void createNode(String name){
							
								node.set(parent.get().createNode(name))
							
							}
							static ExtentTest getNode(){
								
									return node.get()
								
								}
	
								private static ExtentReports getExtent() {
									
										if (extent == null) {
											extent = ExtentManager.getInstance()
										}
									
										return extent
									}
}
