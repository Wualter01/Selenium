package renastech2.day1_Intro.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1_Google_Title_Verification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //below is syntax for using if statement to verify title putting expected title in a String
        driver.get("https://google.com");

        //verify title expected: google
        String expectedTitle="amazon";
        //below fetches actual title and stores it in actualTitle and so we can now call actualTtile
        String actualTitle=driver.getTitle();
//below we are using if/else statement to verify if test passed or failed based on expected title
        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Title verification has passed");
        }else{
            System.out.println("google verification has failed");

        }
        //below is so that if it fails i can still see what actual title is but this will print regardless..
        //if passed or failed
        System.out.println("browser title is: "+actualTitle);
    }
}
