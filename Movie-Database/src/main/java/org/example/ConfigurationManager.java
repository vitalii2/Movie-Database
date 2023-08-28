package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private final String filmApiUrl;
    private final String genreApiUrl;
    private final String url;
    private final String url2;
    private final String username;
    private final String password;

    private ConfigurationManager() {
        Properties properties = new Properties();
        String tempFilmApiUrl, tempGenreApiUrl, tempUrl, tempUsername, tempPassword, tempUrl2;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");) {
            properties.load(inputStream);
            tempFilmApiUrl = properties.getProperty("filmApiUrl");
            tempGenreApiUrl = properties.getProperty("genreApiUrl");
            tempUrl = properties.getProperty("url");
            tempUrl2 = properties.getProperty("url2");
            tempUsername = properties.getProperty("username");
            tempPassword = properties.getProperty("password");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Failed to load configuration values from properties file.");
        }
        filmApiUrl = tempFilmApiUrl;
        genreApiUrl = tempGenreApiUrl;
        url = tempUrl;
        url2 = tempUrl2;
        username = tempUsername;
        password = tempPassword;
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getFilmApiUrl() {
        return filmApiUrl;
    }

    public String getGenreApiUrl() {
        return genreApiUrl;
    }

    public String getDataBaseUrl() {
        return url;
    }

    public String getUrl2() {return url2;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
