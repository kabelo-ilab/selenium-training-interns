import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NewEmployee {

    @BeforeAll
    void setup(){

    }

    @Test
    @DisplayName("Login")
    @Order(1)
    void login(){

    }

    @Test
    @DisplayName("Access dashboard menu items")
    @Order(2)
    void openDashboard(){

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/New Employees.csv", numLinesToSkip = 1)
    @Order(3)
    void addNewEmployee(){

    }

}
