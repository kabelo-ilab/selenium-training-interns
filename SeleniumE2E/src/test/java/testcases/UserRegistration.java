package testcases;

import org.junit.jupiter.api.*;
import test_utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRegistration extends BaseTest {

    @BeforeAll
    void setUp() throws Exception {
        initialize();
    }

    @Test
    @DisplayName("Open Login page")
    @Order(1)
    void openLoginPage(){
        loginPage = homePage.clickSignUpLink();
    }
    @Test
    @DisplayName("New User Signup!")
    @Order(2)
    void newUserSignUp(){
        loginPage.enterNameAndEmail("Tom","Peirone@gmail.com");
        signPage = loginPage.clickSignUpButton();
    }
    @Test
    @DisplayName("Enter Account Information")
    @Order(3)
    void enterAccountInfo(){

        signPage.selectTitle("Mr")
                .setPassword("pass1234")
                .setFirstname("Tom")
                .setLastname("Smith")
                .setCompany("Google")
                .setAddress1("2025 Main Street").setCountry("Canada")
                .setState("Toronto").setCity("Toronto")
                .setZipCode("M3C 0E4").setMobile("0123456987");

        try {
            Thread.sleep(3000);

            signPage.scrollToButton();
            accountCreatedPage = signPage.clickCreateAccount();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @DisplayName("Confirm Account Creation")
    @Order(4)
    void confirmAccountCreation(){
        assertEquals(accountCreatedPage.getPageHeading(), "account created!");
    }
    @AfterEach
    void createReport(TestInfo info){
        createTestReport(info);
    }

    @AfterAll
    void close(){
        tearDown();
    }

}
