package renastech2.day1_Intro.Day6;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class C2_JavaFaker {

    @Test
    public void TC1_javaFaker(){
        //in order to use java faker we need java faker object(instance) example the following
        //it always needs to be setup
        Faker faker = new Faker();
        System.out.println("faker.name().fullName()= "+faker.name().fullName());
        System.out.println(faker.name().firstName());
        System.out.println(faker.address().cityName());
        System.out.println(faker.gameOfThrones().dragon());
        System.out.println(faker.lordOfTheRings().character());
        System.out.println(faker.artist().name());
    }
}
