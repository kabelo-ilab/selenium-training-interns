package POM_Implementation.utility;

import POM_Implementation.pages.HomePage;
import POM_Implementation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.time.Duration;

public class UserLogin extends BaseTest {
    public static void main(String[] args) {
        setup();
        validUsernameAndValidPassword();
        //validUsernameAndInvalidPassword();
    }

    static void validUsernameAndValidPassword(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage.login("Admin","admin123");
        homePage = loginPage.clickLogin();
        //verify
        System.err.println(homePage.getUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
    }

    static void validUsernameAndInvalidPassword(){
        loginPage.login("Admin","admin1234");
        homePage = loginPage.clickLogin();
        //verify
        System.err.println(loginPage.getErrorMsg().equals("Invalid credentials"));

    }
    static void invalidUsernameAndValidPassword(){


    }
    static void invalidUsernameAndInvalidPassword(){

    }




}
