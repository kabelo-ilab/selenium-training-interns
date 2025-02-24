package Chapter2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GetStarted {

    public static void main(String[] args) {
        //initialize web driver object
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

        //display some properties
       display(driver);
       //open a new tab
       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.ilabquality.com/");
       display(driver);
       driver.navigate().back();//error, cannot navigate back
       display(driver);

            driver.quit();
    }

    static void display(WebDriver driver){
        System.out.println("===================================");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Window ID: " + driver.getWindowHandle());
    }

}
