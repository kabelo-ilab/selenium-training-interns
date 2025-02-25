package POM_Implementation.pages;

import POM_Implementation.utility.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getUrl() {
        return url;
    }
}
