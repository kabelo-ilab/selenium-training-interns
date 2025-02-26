package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_utils.BasePage;

import java.time.Duration;

public class SignUpPage extends BasePage {

    //private By rdoTitle = By.cssSelector("");
    private By txtFirstname = By.cssSelector("#first_name");
    private By txtLastname = By.cssSelector("#last_name");
    private By txtEmail = By.cssSelector("");
    private By txtPassword = By.cssSelector("#password");
    private By txtCompany = By.cssSelector("#company");
    private By txtAddress1 = By.cssSelector("#address1");
    private By txtAddress2 = By.cssSelector("#address2");
    private By cmbCountry = By.cssSelector("#country");
    private By txtState = By.cssSelector("#state");
    private By txtCity = By.cssSelector("#city");
    private By txtZip = By.cssSelector("#zipcode");
    private By txtMobile = By.cssSelector("#mobile_number");
    private By btnCreateAccount = By.cssSelector("button[data-qa='create-account']");
    private By search = By.cssSelector("#susbscribe_email");

    public SignUpPage(WebDriver theDriver) {
        super(theDriver);
    }

    public SignUpPage selectTitle(String title) {

        WebElement rdoTitle = null;
        if (title.equals("Mr")){
           rdoTitle = driver.findElement(By.cssSelector("#id_gender1"));
        }else if(title.equals("Mrs")){
           rdoTitle = driver.findElement(By.cssSelector("#id_gender2"));
        }
        rdoTitle.click();
        return this;
    }

    public SignUpPage setFirstname(String firstname) {
        driver.findElement(txtFirstname).sendKeys(firstname);
        return this;
    }

    public SignUpPage setLastname(String lastname) {
        driver.findElement(txtLastname).sendKeys(lastname);
        return this;
    }

    public SignUpPage setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
        return this;
    }

    public SignUpPage setPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
        return this;
    }

    public SignUpPage setCompany(String company) {
        driver.findElement(txtCompany).sendKeys(company);
        return this;
    }

    public SignUpPage setAddress1(String address1) {
        driver.findElement(txtAddress1).sendKeys(address1);
        return this;
    }

    public SignUpPage setAddress2(String address2) {
        driver.findElement(txtAddress2).sendKeys(address2);
        return this;
    }

    public SignUpPage setCountry(String country) {
        WebElement countries = driver.findElement(cmbCountry);
        Select countryOptions = new Select(countries);
        countryOptions.selectByValue(country);
        return this;
    }

    public SignUpPage setState(String state) {
        driver.findElement(txtState).sendKeys(state);
        return this;
    }

    public SignUpPage setCity(String city) {
        driver.findElement(txtCity).sendKeys(city);
        return this;
    }

    public SignUpPage setZipCode(String zip) {
        driver.findElement(txtZip).sendKeys(zip);
        return this;
    }

    public SignUpPage setMobile(String mobile) {
        driver.findElement(txtMobile).sendKeys(mobile);
        return this;
    }

    public AccountCreatedPage clickCreateAccount(){
        WebElement btnCreate = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnCreateAccount));

        btnCreate.click();
        return new AccountCreatedPage(driver);
    }
    public void scrollToButton(){
        scrollToElement(search);
    }

}
