package io.github.talhahasanzia;

public class Sample {
    int i;
    String name;
    Weather weather;


    public Sample() {

    }

    @Override
    public String toString() {
        return String.format("int value: %d, String value: %s, enum value: %s", i, name, weather);
    }
}


