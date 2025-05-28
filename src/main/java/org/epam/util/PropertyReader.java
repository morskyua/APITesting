package org.epam.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;
    public String getProperty(String name) {
        return properties.getProperty(name);
    }
    public PropertyReader() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
