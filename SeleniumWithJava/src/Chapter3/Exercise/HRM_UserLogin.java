package Chapter3.Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRM_UserLogin {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        validUsernameAndPassword();
        validUsernameAndInvalidPassword();
    }

    static void validUsernameAndPassword(){

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='username']"));
        txtUsername.sendKeys("Admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='password']"));
        txtPass.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();

    }
    static void validUsernameAndInvalidPassword(){

    }
    static void invalidUsernameAndValidPassword(){

    }
    static void invalidUsernameAndInvalidPassword(){

    }
}
