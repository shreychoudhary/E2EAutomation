package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("E2E Automation Report");
		reporter.config().setReportName("SDET Enterprise Report");
		reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Build Number", System.getenv("BUILD_NUMBER"));
		return extent;
	}
}
