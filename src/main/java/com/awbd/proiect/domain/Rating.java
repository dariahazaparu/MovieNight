package com.awbd.proiect.domain;

public enum Rating {
    BelowExpectations("BelowExpectations"),
    Good("Good"),
    AboveExpectations("AboveExpectations");


    private String description;

    public String getDescription() {
        return description;
    }

    Rating(String description) {
        this.description = description;
    }
}
