package com.quotegenerator.model;

public enum Languages {
    EN("English"),
    UA("Українська");

    public final String changeLanguage;

    Languages(String changeLanguage) {
        this.changeLanguage = changeLanguage;
    }

    public String getChangeLanguage() {
        return changeLanguage;
    }
}