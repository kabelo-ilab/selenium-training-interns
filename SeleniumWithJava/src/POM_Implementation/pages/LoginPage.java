package POM_Implementation.pages;

import POM_Implementation.utility.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By txtUsername = By.cssSelector("input[name='username']");
    private final By txtPassword = By.cssSelector("input[name='password']");
    private final By btnLogin = By.cssSelector("button[type='submit']");
    private String url = "";
    private final By lblErrorMsg = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username, String pass){
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(pass);
    }

    public HomePage clickLogin(){
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }
    public String getErrorMsg(){
        return driver.findElement(lblErrorMsg).getText();
    }
}
