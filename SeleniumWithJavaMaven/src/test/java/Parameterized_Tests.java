import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Parameterized_Tests {

    @ParameterizedTest(name = "Test Even Numbers")
    @ValueSource(ints = {2, 5, 8, 10, 7, 34})
    void testEvenNumbers(int number){
        System.out.println("number = " + number);

    }

    @ParameterizedTest
    @CsvSource(value = {"Coke,19.99","Milk,18.99","Bread,17.00"})
    void testProductPrices(String name, double price){

        if (price <= 17){
            System.out.println(name.toUpperCase() + ", price = " + price);
        }
    }

    @ParameterizedTest
    @MethodSource("personDetails")
    void testDifferentTypes(String firstname, String lastname, int age, double height, boolean isMarried){
        System.out.println(firstname + " " + lastname + ", age = " + age + ", height = " + height + ", isMarried? " + isMarried);
    }

    @ParameterizedTest
    @MethodSource("Person#getHobbies")
    void testPersonHobbies(String hobby){
        System.out.println("hobby = " + hobby);
    }

    Stream<Arguments> personDetails(){
        return Stream.of(
                Arguments.arguments("Tom", "Smith", 34, 1.88, true),
                Arguments.arguments("Jessica", "Pearson", 44, 1.78, true),
                Arguments.arguments("Mike", "Ross", 30, 1.85, false),
                Arguments.arguments("Rachael", "Zane", 29, 1.69, false)
        );
    }


}
