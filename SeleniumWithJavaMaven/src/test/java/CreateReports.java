import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.manager.SeleniumManagerOutput;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateReports {
    WebDriver driver;
    String reportUrl = "src/test/resources/reports/Spark.html";
    ExtentReports extent;
    ExtentSparkReporter sparkRpt;
    boolean isPass;

    @BeforeAll
    void setup(){
        isPass = false;
        extent = new ExtentReports();
        sparkRpt = new ExtentSparkReporter(reportUrl);
        sparkRpt.config().setTheme(Theme.STANDARD);
        sparkRpt.config().setDocumentTitle("Extent Reports Demo");
        sparkRpt.config().setReportName("Spark Report");

        driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    @DisplayName("Login")
    @Order(1)
    void login(){
        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='username']"));
        txtUsername.sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        isPass = txtUsername.getText().equals("Admin");
        assertTrue(isPass);
    }

    @Test
    @DisplayName("Open PIM Page")
    @Order(2)
    void openPIM(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]"))
                .click();
        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeLis";
        String actual = driver.getCurrentUrl().toString();

        isPass = expected.equals(actual);
        assertTrue(isPass, "The URL should be: \nhttps://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }

    @BeforeEach
    @DisplayName("Generate Test Report")
    void createTestReport(TestInfo info){

        ExtentTest myTest = extent.createTest(info.getDisplayName());

        try {
            Thread.sleep(3000);
            File sourceFile = ((TakesScreenshot)(driver))
                    .getScreenshotAs(OutputType.FILE);

//            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//            String fileName = info.getDisplayName() + "_[" + timeStamp + "].png";
//
//            File destinationFile = new File("src/test/resources/screen shots/" + fileName);
//
//            Files.move(sourceFile, destinationFile);
            String image = ((TakesScreenshot)(driver))
                    .getScreenshotAs(OutputType.BASE64);

            if (isPass){
                myTest.log(Status.PASS,"Test successful for {} " + info.getDisplayName());
            }else{
                myTest.log(Status.PASS,"Test failed for {} " + info.getDisplayName());
            }
            myTest.addScreenCaptureFromBase64String(image);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @AfterAll
    void tearDown(){
        extent.attachReporter(sparkRpt);
        extent.flush();

        try {
            Desktop.getDesktop().browse(new File(reportUrl).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
