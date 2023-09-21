package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

    Properties prop;
    FileInputStream inputStream;

    private void readPropFile() {
        try {
            prop = new Properties();
            inputStream = new FileInputStream("src/test/resources/config/globalconfig.properties");
            prop.load(inputStream);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String getValue(String value) {
        readPropFile();
        return prop.getProperty(value);

    }
}
