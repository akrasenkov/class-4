package com.company;

public enum ForecastMode {

    TODAY("today"),
    TOMORROW("tomorrow");

    private String optionName;

    ForecastMode(String name) {
        this.optionName = name;
    }

    public String getOptionName() {
        return optionName;
    }
}
