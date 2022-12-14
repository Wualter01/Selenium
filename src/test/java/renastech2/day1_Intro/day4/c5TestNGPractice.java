package renastech2.day1_Intro.day4;

import org.testng.annotations.*;

public class c5TestNGPractice {
    //Before class and after class will only run one time because we only have the one class if we were to have
    //more than one class then that number would change to however many classes we have
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

    @Test
    public void TC1(){
        System.out.println("Test case 1 is running TC_1");
    }

    @Test
    public void TC2(){
        System.out.println("Test2 is running");
    }

    @Test
    public void TC3(){
        System.out.println("Test3 is running");
    }
}
