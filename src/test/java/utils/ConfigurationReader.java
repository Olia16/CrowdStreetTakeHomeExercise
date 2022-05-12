package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    public static Properties properties = new Properties();

    static {
        try {
            FileInputStream inputStream = new FileInputStream("configuration.properties");
            properties.load(inputStream);
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading configuration file");
        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}
