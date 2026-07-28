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
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.aventstack.extentreports.reporter.configuration.Theme
import java.text.SimpleDateFormat

public class ExtentManager {

	private static ExtentReports extent

    static ExtentReports getInstance() {

		println("===== ExtentManager.getInstance() =====")
		
        if (extent == null) {

			println("===== Creating Extent Report =====")
            //===========================
            // Report Path
            //===========================

            String reportFolder = ReportFolderManager.getReportFolder()

            File folder = new File(reportFolder)

            if (!folder.exists()) {
                folder.mkdirs()
            }

            String reportPath = reportFolder + "/ExtentReport.html"
			println(reportPath)

            //===========================
            // Spark Reporter
            //===========================

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath)

            spark.config().setDocumentTitle("Utajir Creator Reprot")
            spark.config().setReportName("Utajir Creator Automation")
            spark.config().setEncoding("UTF-8")

            // يمكنك تغيير الثيم لو أردت
            // spark.config().setTheme(Theme.DARK)

            //===========================
            // Extent Report
            //===========================

            extent = new ExtentReports()

            extent.attachReporter(spark)

            //===========================
            // System Information
            //===========================

            extent.setSystemInfo("Project", MetadataManager.project)
            extent.setSystemInfo("Tester", MetadataManager.tester)
            extent.setSystemInfo("Framework", MetadataManager.framework)
            extent.setSystemInfo("Language", MetadataManager.language)
            extent.setSystemInfo("Environment", MetadataManager.environment)
            extent.setSystemInfo("Execution", MetadataManager.execution)
            extent.setSystemInfo("Browser", MetadataManager.browser)

            extent.setSystemInfo(
                    "Operating System",
                    System.getProperty("os.name"))

            extent.setSystemInfo(
                    "OS Version",
                    System.getProperty("os.version"))

            extent.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version"))

            extent.setSystemInfo(
                    "Suite Started",
                    SuiteManager.getStartTime())
        }

        return extent
    }

    static void flush() {

        if (extent != null) {

        println("===== FLUSH =====")

        extent.flush()
    }
    else {

        println("===== EXTENT IS NULL =====")
    }
    }

    static String getReportFolder() {
        return ReportFolderManager.getReportFolder()
    }
}
