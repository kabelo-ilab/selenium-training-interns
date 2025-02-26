package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test_utils.BasePage;

public class LoginPage extends BasePage {
    private By txtName = By.cssSelector("input[name='name']");
    private By txtEmail = By.cssSelector("input[data-qa='signup-email']");
    private By btnSignUp = By.cssSelector("button[data-qa='signup-button']");


    public LoginPage(WebDriver theDriver) {
        super(theDriver);
    }

    public void enterNameAndEmail(String name, String email){
        driver.findElement(txtName).sendKeys(name);
        driver.findElement(txtEmail).sendKeys(email);
    }

    public SignUpPage clickSignUpButton(){
        driver.findElement(btnSignUp).click();
        return new SignUpPage(driver);
    }
}
