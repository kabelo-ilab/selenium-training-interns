import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserLogin {
    WebDriver driver;

    @BeforeAll
    void setup(){

    }

    @BeforeAll
    void openTab(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @ParameterizedTest()
    //@CsvSource(value = {"Admin,admin123","Admin,admin","Admin123,admin123"})
    @MethodSource("personList")
    void testValidUsernameAndValidPassword(Person p){

        driver.switchTo().newWindow(WindowType.TAB);
        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(p.getUsername());
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(p.getPassword());
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //WebElement lblError = driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text"));

        String actual = driver.getCurrentUrl().toString();

        System.out.println("firstaname = " + p.getFirstaname() + ", lastname = " + p.getLastname() + ", username = " + p.getUsername() + ", password = " + p.getPassword() +
                ", phone = " + p.getPhone() + ", email = " + p.getEmail() + ", age = " + p.getAge());
        assertEquals(expected,actual);

    }

    List<Person> personList(){
        return List.of(
                new Person("Mike","Ross","admin","admin","0123456987","mike@gmail.com",30),
                new Person("Jessica","Perason","Admin","admin123","0123456987","jess@gmail.com",40),
                new Person("Harvey","Specter","Admin","admin123","0123456987","harvey@gmail.com",41),
                new Person("Rachael","Zane","admin","admin123","0123456987","rachael@gmail.com",28)
        );
    }
    Stream<Arguments> personDetails(){
        return Stream.of(
                arguments("Mike","Ross","admin","admin","0123456987","mike@gmail.com",30),
                arguments("Jessica","Perason","Admin","admin123","0123456987","jess@gmail.com",40),
                arguments("Harvey","Specter","Admin","admin123","0123456987","harvey@gmail.com",41),
                arguments("Rachael","Zane","admin","admin123","0123456987","rachael@gmail.com",28)
        );
    }
}
