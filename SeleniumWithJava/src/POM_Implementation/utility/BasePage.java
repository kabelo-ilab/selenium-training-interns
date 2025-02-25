package POM_Implementation.utility;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver theDriver){this.driver = theDriver;}
}
