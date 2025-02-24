package Chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebElementsInteractions {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        //fillInForm();
        //dropDownList();
        multiSelectDropdown();

    }
    static void multiSelectDropdown(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://ironspider.ca/forms/dropdowns.htm");

        WebElement coffeeOptions = driver.findElement(By.cssSelector("select[name='coffee2']"));
        Select coffeeMenu = new Select(coffeeOptions);

        coffeeMenu.selectByValue("whipped");
        coffeeMenu.selectByValue("honey");
        coffeeMenu.selectByValue("muffin");
        coffeeMenu.deselectByIndex(2);

        System.out.println("Is this a multi-select? " + coffeeMenu.isMultiple());

        List<WebElement> myOptions = coffeeMenu.getAllSelectedOptions();

        for (WebElement option : myOptions){
            System.out.println(option.getTagName() + " : " +option.getText());
        }
    }

    static void dropDownList(){
        WebElement linkDropdown = driver.findElement(By.linkText("Dropdown"));
        //click the link
        linkDropdown.click();

        WebElement cmbOptions = driver.findElement(By.cssSelector("select[id='dropdown']"));
        Select selectOptions = new Select(cmbOptions);

        selectOptions.selectByVisibleText("Option 2");

    }

    static void fillInForm(){
        WebElement linkLogin = driver.findElement(By.linkText("Form Authentication"));
        //click the link
        linkLogin.click();
        WebElement txtUsername = driver.findElement(By.cssSelector("input[id='username']"));
        //type username
        txtUsername.sendKeys("tomsmith");
        WebElement txtPassword = driver.findElement(By.cssSelector("input[id='password']"));
        //type password
        txtPassword.sendKeys("SuperSecretPassword!");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();
    }
}
