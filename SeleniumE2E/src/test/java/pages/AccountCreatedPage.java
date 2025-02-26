package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test_utils.BasePage;

public class AccountCreatedPage extends BasePage {
    private By lblHeading = By.cssSelector("h2[class='title text-center'] b");
    public AccountCreatedPage(WebDriver theDriver) {
        super(theDriver);
    }

    public String getPageHeading(){
        return driver.findElement(lblHeading).getText().toLowerCase();
    }
}
