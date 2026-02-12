package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance("test-output/ExtentReport.html");
		return extent;
	}

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("SDET Framework Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
}
