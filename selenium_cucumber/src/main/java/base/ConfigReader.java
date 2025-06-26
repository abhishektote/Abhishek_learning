package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static util.ProjectConstants.LOG_FAILED_TO_LOAD_PROPS;
import static util.ProjectConstants.PATH_TO_CONFIG;

public class ConfigReader {
    private static final Properties properties;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_CONFIG);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(LOG_FAILED_TO_LOAD_PROPS, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
