package renastech2.day1_Intro.Day5;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDependsOn {

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
    @Test(priority = 3, dependsOnMethods = "TC3_test")
    public void TC1_test(){
        System.out.println("Test1 is running");
    }
    @Test(priority = 1)
    public void TC3_test(){
        System.out.println("Test3 is running");
        String actualWord="hello";
        String expectedWord="hello2";

        /* if (actualWord.equals(expectedWord)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            }
         */
        Assert.assertEquals(actualWord,expectedWord);

    }
    @Test(priority = 2)
    public void TC_2(){
        System.out.println("Test2 is running");
        String str="RenasTech";
        String str2="RenasTech";

        Assert.assertTrue(str.equals(str2));//having multiple methods with the same name and different
        // parameters or different amount is called overloading
    }

    @Ignore//will ignore this test and not run
    @Test
    public void TC4_test(){
        System.out.println("Running test4");
    }

}
