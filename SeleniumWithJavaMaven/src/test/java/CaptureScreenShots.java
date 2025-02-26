import com.google.common.io.Files;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CaptureScreenShots {
    WebDriver driver;

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Login")
    @Order(1)
    void login(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Test
    @DisplayName("Open PIM Page")
    @Order(2)
    void openPIM(){
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
        //.oxd-main-menu-item.active
    }

    @BeforeEach
    void takeScreenShot(TestInfo info){

        try {
            Thread.sleep(3000);
            File sourceFile = ((TakesScreenshot)(driver))
                    .getScreenshotAs(OutputType.FILE);

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String fileName = info.getDisplayName() + "_[" + timeStamp + "].png";

            File destinationFile = new File("src/test/resources/screen shots/" + fileName);

            Files.move(sourceFile, destinationFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
