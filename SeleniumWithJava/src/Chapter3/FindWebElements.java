package Chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindWebElements {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        accessById();
        accessByName();
        accessByCss();
        absoluteXpath();
        relativeXpath();

    }

    static void accessById(){
        WebElement txtName = driver.findElement(By.id("name"));
        display(txtName, "By id");
    }
    static void relativeXpath(){
        WebElement txtSubjects = driver.findElement(By.xpath("//input[@id=\"subjects\"]"));
        display(txtSubjects, "By Relative Xpath");
    }
    static void absoluteXpath(){
        WebElement txtMobile = driver.
                findElement(By.xpath("/html/body/main/div/div[1]/div[2]/form/div[4]/div/input"));
        display(txtMobile, "Absolute xpath");

    }
    static void accessByName(){
        WebElement txtEmail = driver.findElement(By.name("email"));
        display(txtEmail,"By name");
    }
    static void accessByCss(){
        WebElement rdoGender = driver.findElement(By.cssSelector("input[id='gender']"));
        display(rdoGender, "By Css Selector");
        //input[id='gender']
    }

    static void display(WebElement element, String locator){
        System.out.println("============== " + locator + " =================");
        System.out.println("Tag name : " + element.getTagName());
        System.out.println("Accessible Name : " + element.getAccessibleName());
        System.out.println("X : " + element.getLocation().x + "  Y : " + element.getLocation().y);

    }
}
