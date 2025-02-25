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

    @BeforeEach
    void openTab(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @ParameterizedTest()
    //@CsvSource(value = {"Admin,admin123","Admin,admin","Admin123,admin123"})
    @MethodSource("personList")
    void testValidUsernameAndValidPassword(String firstaname, String lastname, String username, String password, String phone, String email, int age){

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //WebElement lblError = driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text"));

        String actual = driver.getCurrentUrl().toString();

        System.out.println("firstaname = " + firstaname + ", lastname = " + lastname + ", username = " + username + ", password = " + password + ", phone = " + phone + ", email = " + email + ", age = " + age);
        assertEquals(expected,actual);

    }

    Stream<Arguments> personList(){
        return Stream.of(
                arguments("Mike","Ross","admin","admin","0123456987","mike@gmail.com",30),
                arguments("Jessica","Perason","Admin","admin123","0123456987","jess@gmail.com",40),
                arguments("Harvey","Specter","Admin","admin123","0123456987","harvey@gmail.com",41),
                arguments("Rachael","Zane","admin","admin123","0123456987","rachael@gmail.com",28)
        );
    }
}
