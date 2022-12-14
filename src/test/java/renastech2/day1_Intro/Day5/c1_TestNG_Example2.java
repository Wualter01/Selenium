package renastech2.day1_Intro.Day5;

import org.testng.Assert;
import org.testng.annotations.*;

public class c1_TestNG_Example2 {
    @BeforeClass
    public void setupClass(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void setUpAfterClass(){
        System.out.println("After class is running");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("before Method is running");
    }

    @AfterMethod
    public void closing(){
        System.out.println("After method is running");
    }
//below we are using dependsOnMethods so if "TC3_test3" passes then this one will execute if not it won't
    @Test(priority = 3,dependsOnMethods = "TC3_test3")
    public void TC1_test1(){
        System.out.println("Test1 is running");
    }
    @Test(priority = 1)
    public void TC3_test3(){
        System.out.println("Test3 is running");
        String actualWord = "BMW";
        String expectedWord = "Honda";
        //the assert condition is Equals so in order for it to pass strings must match and they do not in this ex:
        //also anything after failed assert equals condition will not run"continue test3" wont be executed because
        //of depends on method not because code broke cuz of failure
        Assert.assertEquals(actualWord,expectedWord);
        System.out.println("continue test3");
    }
    @Test(priority = 2)
    public void TC2_test2(){
        System.out.println("Test2 is running");
        String str= "USA";
        String str2="USA";
        //this assertTrue condition is boolean (true, false) we must write whatever we are comparing in this case
        //str.EQUALS*str2 <---syntax
        Assert.assertTrue(str.equals(str2));
    }

    @Ignore
    @Test
    public void TC4_test4(){
        System.out.println("Test4 is running");
    }
}
//your result here would be test failed: 1   passed:1   ignored:1
//shows only 3 because test1 depended on test3 which had assert conditon EQUALS since strings did not equal(match)
//it did not run test1 hence depends on test3 passing