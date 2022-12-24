package renastech2.day1_Intro.utilities;

public class BrowserUtils {
    ///create an utility method called wait
//static method //return type void : static so you can call with class reference
//parameter should be int second //goal of the method:
//handle thread. sleep with try catch multiple with second parameter

    public static void wait(int second) {// we can handle either with try catch or throws
        //i can overload this method with different parameters if i were to do it for minutes instead of seconds
        try {
            Thread.sleep(1000 * second); //100 millis seconds is 1 second so 1*1 is 1 and so on
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
