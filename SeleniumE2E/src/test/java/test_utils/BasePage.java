package test_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver theDriver){
        this.driver = theDriver;
    }

    public WebElement scrollToElement(By byElement){
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(byElement);
        actions.scrollToElement(webElement).perform();
        return webElement;
    }
}
