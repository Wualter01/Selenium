package renastech2.day1_Intro.utilities;

public class BrowserUtils {
     /* create a utility method called wait, static method so i can call by using name
     remember static method can be called from anywhere. return type void, parameter should be int second
     goal of the method :
     handle thread.sleep with try catch multiple with second parameter
     BASICALLY WE ARE CREATING THREAD ASLEEP SO THAT WE DONT HAVE TO CREATE EACH TIME AND PARAMETER IS CREATED SO THAT
     WE CAN GIVE IT HOWEVER MUCH TIME WE WANT
     we have named our method wait and that is how we will call from now on
      */


public static void wait(int second) throws InterruptedException {
    try {
        Thread.sleep(1000*second);
}catch (InterruptedException e){
        e.printStackTrace();
        //the above code is set to catch exception if you so happen to have one so that your code doesnt break
        // and you may continue to run it is called try catch block
        //in the try section i am saying try thread.sleep and in catch i am saying catch exception if there is one
        //as you know when you use thread asleep it always throws interruptedException and this code block will prevent
        //it from breaking the rest of your code. you may write different things in try section not just thread.asleep
    }
    }
}