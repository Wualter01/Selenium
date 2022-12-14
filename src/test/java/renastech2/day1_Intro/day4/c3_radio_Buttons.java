package renastech2.day1_Intro.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c3_radio_Buttons {
    public static void main(String[] args) throws InterruptedException {
        //Navigate to https://courses.letskodeit.com/practice
        //click on BMW RADIO button
        //verify selected

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement BMWRadioButton = driver.findElement(By.id("bmwradio"));
        BMWRadioButton.click();

        //this is adding true or false condition
        boolean bmwRadioSelected= BMWRadioButton.isSelected();
        if (bmwRadioSelected){
            System.out.println("Bmw is selected");
        }else{
            System.out.println("Bmw is not selected, verification has failed");
        }
//verify honda button is not selected
        WebElement HondaSelectButton = driver.findElement(By.xpath("//input[@id='hondaradio']"));
        if (!HondaSelectButton.isSelected()){
            System.out.println("honda button is not selected");
        }else {
            System.out.println("honda button is selected, verification failed");

        }
    }
}
