package renastech2.day1_Intro.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class RadioButtons2 {

/*
Navigate to https://courses.letskodeit.com/practice
click on BMW RADIO button verify that its selected
Check Bmw, Benz, honda validate that benz i
 */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://courses.letskodeit.com/practice" );
        WebElement BMWRadioButton = driver.findElement(By.xpath("//input[@id='bmwradio']"));
        BMWRadioButton.click();

        boolean BMWRadioSelected =BMWRadioButton.isSelected();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//always good to use just in case
        if(BMWRadioSelected){//we have passed our boolean which returns true or false. because of this it'll check
            //condition and if true continue to bmw is selected if false it goes to else
            System.out.println("BMW is selected");
        }else{
            System.out.println("BMW is not selected, test failed");
        }

        WebElement HondaRadioButton = driver.findElement(By.xpath("//input[@id='hondaradio']"));
        HondaRadioButton.click();

        if (!HondaRadioButton.isSelected()){
            System.out.println("honda button is not selected, test passed");
        }else{
            System.out.println("honda button is selected, test failed");
        }

        Thread.sleep(2000);
        driver.close();

    }

}
