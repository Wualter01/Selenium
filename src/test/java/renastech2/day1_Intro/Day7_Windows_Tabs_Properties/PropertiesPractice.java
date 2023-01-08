package renastech2.day1_Intro.Day7_Windows_Tabs_Properties;

import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.PropertiesReaderUtil;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesPractice {

    @Test
    public void TC1_SystemProperties(){
        //java has some ready properties that you can get system info
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }

    @Test
    public void TC3_configurationProperties() throws FileNotFoundException {
        System.out.println(PropertiesReaderUtil.getProperties("SmartBear_url"));
        System.out.println(PropertiesReaderUtil.getProperties("SmartBear_password"));
    }
}
