package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilsSettings {


    private Properties properties = propertiesInitialize();

    public Properties propertiesInitialize() {

        String config = "config.properties";

        Properties properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(config);
            properties.load(inputStream);
        } catch (IOException e) {
            e.getMessage();
        }
        return properties;
    }

    public Properties getProperties() {
        return properties;
    }
}
