package com.quotegenerator.model;

import lombok.Getter;

@Getter
public enum Languages {
    EN("English"),
    UA("Українська");

    public final String language;

    Languages(String language) {
        this.language = language;
    }
}