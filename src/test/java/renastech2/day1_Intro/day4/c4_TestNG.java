package renastech2.day1_Intro.day4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class c4_TestNG {

    @BeforeMethod
    public void setup(){
        System.out.println("Runs before Method ");}
    @AfterMethod
    public void closing(){
        System.out.println("After Method is running ");}

    @Test
    public void TC1_test(){
        System.out.println("TC1 is running");}

    @Test
    public void TC2_test(){
        System.out.println("TC2 is running");}

    @Test
    public void TC3_test(){
        System.out.println("Test case 3 is running");

    }
}
