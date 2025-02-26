import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CreatingReports {
    public static void main(String[] args) {

        String reportUrl = "src/main/resources/reports/Spark.html";

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter sparkRpt = new ExtentSparkReporter(reportUrl);

        //configure the report
        sparkRpt.config().setTheme(Theme.STANDARD);
        sparkRpt.config().setDocumentTitle("Extent Reports Demo");
        sparkRpt.config().setReportName("Spark Report");

        extent.attachReporter(sparkRpt);

        //Create tests
        ExtentTest test1 = extent.createTest("Test 1");
        test1.pass("The has passed");
        ExtentTest test2 = extent.createTest("Test 2");
        test2.fail("Test has failed");
        ExtentTest test3 = extent.createTest("Test 3");
        test3.warning("This is just a warning");

        ExtentTest test4 = extent.createTest("Test 4");
        test4.log(Status.INFO,"This is just an info");
        ExtentTest test5 = extent.createTest("Test 5");
        test5.log(Status.SKIP,"This test is skipped");



        extent.flush();

        try {
            Desktop.getDesktop().browse(new File(reportUrl).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
