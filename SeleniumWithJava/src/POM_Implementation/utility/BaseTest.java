package POM_Implementation.utility;

import POM_Implementation.pages.HomePage;
import POM_Implementation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseTest {
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static WebDriver driver;

    public static void setup(){
        driver = initializeDriver("chrome","https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }
    public static void openNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static WebDriver initializeDriver(String browser, String url){

        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}
