package renastech2.day1_Intro.day4;

import org.testng.annotations.*;

public class c5TestNGPractice {

    @BeforeClass
    public void setupClass(){//will run once before everything in class per class unless you have multiple classes
        //then it would change
        System.out.println("Before class is running");
    }
    @AfterMethod
    public void setupAfterClass(){//will only run once after everything in your class (at the end)
        System.out.println("After class is running");
    }
    @BeforeMethod
    public void setup(){//runs before EACH @Test annotation
        System.out.println("Before method is running");
    }
    @AfterMethod
    public void closing(){//will run After each @Test annotation
        System.out.println("After method is running");
    }
    @Test
    public void TC1_test(){
        System.out.println("Test1 is running");
    }
    @Test
    public void TC3_test(){
        System.out.println("Test3 is running");
    }
    @Test
    public void TC_2(){
        System.out.println("Test2 is running");
    }
}
