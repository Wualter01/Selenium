package renastech2.day1_Intro.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderUtil {

    //1- create properties object
//2- get the path and store in String
//3- open the file use FileInputStream method
//4- Load the file to properties object by using load method from properties
//5- close.file
//plus dont forget to handle exceptions

private static Properties properties= new Properties();
//encapsulation hide the data

    static {//will get executed before everything
      //2- get path and store in string
        String pathForPropertiesFile= "Configuration.properties";
        //3- open the file use FileInputStream method
        //we need to tell compiler to open this file
        try {
            FileInputStream fileInputStream= new FileInputStream(pathForPropertiesFile);

            //4- Load the file to properties object by using load method from properties
            properties.load(fileInputStream);//file needs to be loaded in automation, we used load method that comes
            //from properties
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("properties file not found!");
        }
    }

    public static String getProperties(String keyword){
        return properties.getProperty(keyword); //this is an example of encapsulation we used a private variable
        //and we used a getter method to get our data that was private
    }
}
