package renastech2.day1_Intro.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

//1. Open Chrome browser
//2. Go to https://demo.gru99.com/test/radio.html
//3. Verify checkbox1 is not selected
//4. Click to checkbox2
//5. Verify checkBox2 is selected


public class checkBox2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement checkBox1= driver.findElement(By.id("vfb-6-0"));

        if (checkBox1.isSelected()){
            System.out.println("checkBox1 is selected");
        }else{
            System.out.println("checkbox1 is not selected");
        }

        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        checkBox2.click();
        Thread.sleep(2000);

        if (checkBox2.isSelected()){
            System.out.println("checkBox2 is selected");
        }else{
            System.out.println("checkBox2 is not selected");
        }
        //driver.close();

    }
}
