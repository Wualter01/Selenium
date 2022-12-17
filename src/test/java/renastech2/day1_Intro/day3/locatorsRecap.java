package renastech2.day1_Intro.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class locatorsRecap {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://google.com");
        String containsTitle="Images";
        Thread.sleep(2000);
        WebElement ImagesButton = driver.findElement(By.linkText("Images"));
        ImagesButton.click();
        String actualTitle = driver.getTitle();
        Thread.sleep(2000);

        if (actualTitle.contains(containsTitle)){
            System.out.println("contains Images verification passed!");
        }else{
            System.out.println("title contains Images has failed!");
            System.out.println("actualTitle = " + actualTitle);
        }
        driver.close();
    }
}
