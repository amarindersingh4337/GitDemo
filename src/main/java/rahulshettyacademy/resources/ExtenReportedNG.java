package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenReportedNG {

	public static ExtentReports getReportObject() {
		//extentreports, extentsparkreporter
				String path= System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");
				
				ExtentReports extent;
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Amarinder Singh");
				return extent;
	}
}
