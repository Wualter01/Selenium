package renastech2.day1_Intro.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c2_CheckBox {
    /*
    1.open chrome browser
    2.got to https://demo.guru99.com/test/radio.html
    3.verify checkbox1 is not selected
    4.verify checkbox2 is selected
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement CheckBox1 =driver.findElement(By.id("vfb-6-0"));

        //our if statement is checking that checkbox1 is not selected using ! which means not
        //we are also using .isSelected method to help us verify
        if (!CheckBox1.isSelected()){
            System.out.println("Checkbox verification has passed");
        }else{
            System.out.println("Checkbox1 selected therefore verification has failed");
        }
//in order to verify checkbox2 has clicked first store it in webElement and then click it then write your
        //if statement if clicked "verification has passed else verification has failed"
        //using .isSelected again without the !(not)
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='checkbox2']"));
        checkBox2.click();
        if (checkBox2.isSelected()){
            System.out.println("checkBox2 verification has passed");
        }else{
            System.out.println("checkBox2 verification failed");
        }
        Thread.sleep(2000);
        driver.quit();


    }
}

