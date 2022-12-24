package renastech2.day1_Intro.Day6;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void TC1_JavaFakerExample(){

        Faker faker = new Faker();

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.address().cityName() = " + faker.address().cityName());
        System.out.println("faker.gameOfThrones().dragon() = " + faker.gameOfThrones().dragon());
        System.out.println("faker.backToTheFuture().character() = " + faker.backToTheFuture().character());
    }
}
