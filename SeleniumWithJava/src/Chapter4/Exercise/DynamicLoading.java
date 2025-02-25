package Chapter4.Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement examplesHeading = driver.findElement(By.cssSelector("#content > h2"));
        //verify
        System.out.println("Is present? " + isVisible(examplesHeading, "Available Examples"));

        driver.findElement(By.cssSelector("a[href='/dynamic_loading']"))
        .click();
        //verify

       driver.findElement(By.cssSelector("a[href='/dynamic_loading/1']"))
        .click();
        //verify

        //start button
        driver.findElement(By.cssSelector("div[id='start'] button"))
                .click();

        //use a wait strategy
        WebElement lblHelloWorld = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector("div[id='finish'] h4")));
        //verify
        System.out.println("Is present? " + isVisible(lblHelloWorld, "Hello World!"));

    }

    static boolean isVisible(WebElement element, String text){
        return element.getText().equals(text);
    }
}
