package com.armyofthree.refresh.models.dao.implementations.jdbc;

public class ApplicationProperties {

    private final Properties properties;

    public ApplicationProperties() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.ALL, "IOException occurred while loading properties " +
                    "file::::" + e.getMessage());
        }
    }

    public String readProperty(String keyName) {
        return properties.getProperty(keyName, "There is no key in the properties file");
    }
}
