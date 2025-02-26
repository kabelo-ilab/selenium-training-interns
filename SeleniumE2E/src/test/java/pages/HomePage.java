package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test_utils.BasePage;

public class HomePage extends BasePage {
    private By signUpLink = By.cssSelector("a[href='/login']");

    public HomePage(WebDriver theDriver) {
        super(theDriver);
    }

    public LoginPage clickSignUpLink(){
        driver.findElement(signUpLink).click();
        return new LoginPage(driver);
    }
}
