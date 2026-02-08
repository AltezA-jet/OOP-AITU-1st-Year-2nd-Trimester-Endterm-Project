package com.example.musiclibrary.config;

public class AppConfig {

    private static AppConfig instance;

    private AppConfig() {
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() {
        return "Music Library API";
    }
}
