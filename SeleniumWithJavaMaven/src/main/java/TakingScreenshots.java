import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;


public class TakingScreenshots {

    static WebDriver driver;
    public static void main(String[] args) {


        try {
            driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
            driver.manage().window().maximize();


            Thread.sleep(5000);

            //takeScreenShot();
            takeScreenShotBase64();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        } finally {
        }

    }

    static void takeScreenShot() throws IOException {
        File sourceFile = ((TakesScreenshot)(driver))
                .getScreenshotAs(OutputType.FILE);

        File destinationFile = new File("src/main/resources/test12.png");

        Files.move(sourceFile, destinationFile);

    }

    static void takeScreenShotBase64() throws IOException {
        String sourceFile = ((TakesScreenshot) (driver))
                .getScreenshotAs(OutputType.BASE64);

        String destination = "src/main/resources/test123.png";

        File image = new File(destination);

        FileOutputStream fileOutput = new FileOutputStream(image);

        fileOutput.write(Base64.getDecoder().decode(sourceFile));

    }
}
