package Chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HRMLogin {
    static WebDriver driver;
    public static void main(String[] args) {

        driver = new ChromeDriver();


       validUsernameAndPassword();
        validUsernameAndInvalidPassword();
        invalidUsernameAndValidPassword();
        invalidUsernameAndInvalidPassword();

    }
    static void validUsernameAndPassword(){

        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='username']"));
        txtUsername.sendKeys("Admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='password']"));
        txtPass.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();

    }
    static void validUsernameAndInvalidPassword(){

        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='username']"));
        txtUsername.sendKeys("Admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='password']"));
        txtPass.sendKeys("admin12345");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();
    }
    static void invalidUsernameAndValidPassword(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='username']"));
        txtUsername.sendKeys("Admin123");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='password']"));
        txtPass.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();
    }

    static void invalidUsernameAndInvalidPassword(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='username']"));
        txtUsername.sendKeys("Admin123");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='password']"));
        txtPass.sendKeys("admin12345");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();
    }
}
