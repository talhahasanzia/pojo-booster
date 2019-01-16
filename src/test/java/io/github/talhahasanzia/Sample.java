package io.github.talhahasanzia;

import io.github.talhahasanzia.annotation.TestValue;

public class Sample {
    int i;
    String name;

    @TestValue(stringValue = "SPRING")
    Weather constantWeather;


    Weather randomWeather;

    public Sample() {

    }

    @Override
    public String toString() {
        return String.format("int value: %d, String value: %s, constantWeather: %s, randomWeather: %s", i, name, constantWeather, randomWeather);
    }
}


