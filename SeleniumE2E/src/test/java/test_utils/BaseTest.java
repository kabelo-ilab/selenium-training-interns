package test_utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter sReport;
    protected String reportUrl = "src/test/resources/reports/Automation Exercise.html";
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signPage;
    protected AccountCreatedPage accountCreatedPage;

    public void initialize() throws Exception {
        driver = getDriver("chrome","https://automationexercise.com/");
        homePage = new HomePage(driver);

        extent = new ExtentReports();
        sReport = new ExtentSparkReporter(reportUrl);
        sReport.config().setReportName("New User Registration");
        sReport.config().setDocumentTitle("Automation - New User Registration");

        extent.attachReporter(sReport);
    }
    public WebDriver getDriver(String browser, String url) throws Exception {
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }else {
            throw new Exception("Browser not found");
        }

        driver.get(url);
        driver.manage().window().maximize();

        return driver;
    }

    public void createTestReport(TestInfo info){
        ExtentTest myTest = extent.createTest(info.getDisplayName());

        String image = ((TakesScreenshot)(driver))
                .getScreenshotAs(OutputType.BASE64);

        myTest.addScreenCaptureFromBase64String(image);

    }

    public void tearDown(){
        try {
            //driver.quit();
            extent.flush();
            Desktop.getDesktop().browse(new File(reportUrl).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
