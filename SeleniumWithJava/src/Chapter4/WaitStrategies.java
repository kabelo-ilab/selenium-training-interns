package Chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitStrategies {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //theImplicitWait();
        //theExplicitWait();
        theFluentWait();
    }

    static void theImplicitWait(){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='username']"));
        txtUsername.sendKeys("Admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='password']"));
        txtPass.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();
    }

    static void theExplicitWait(){

        WebElement txtUsername = new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
        txtUsername.sendKeys("Admin");

        driver.findElement(By.cssSelector("input[name='password']"))
        .sendKeys("admin123");

        WebElement btnLogin = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        btnLogin.click();
    }

    static void theFluentWait(){

        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.cssSelector("input[name='password']"))
                .sendKeys("admin123");

        WebElement btnLogin = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        btnLogin.click();
    }

}
