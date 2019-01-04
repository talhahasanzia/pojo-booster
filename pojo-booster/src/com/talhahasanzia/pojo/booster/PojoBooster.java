package com.talhahasanzia.pojo.booster;

import com.talhahasanzia.pojo.annotation.Boost;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Course set to Martian Orbit!
 */
public final class PojoBooster {

    // T-10 seconds to lift off, checking all engines...
    public static void boost(Object parent) {


        try {

            // check all boosters
            Field[] boosters = parent.getClass().getDeclaredFields();

            // (pick all fields)
            for (Field booster : boosters) {

                // set these boosters (fields) accessible
                booster.setAccessible(true);

                // filter only required boosters ("Boost" annotated fields)
                if (booster.isAnnotationPresent(Boost.class)) {
                    // start engines!
                    ignite(booster, parent);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    // Ignite the engines!
    private static void ignite(Field booster, Object parent) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        // check if field was standard variable type
        if (isStandardBooster(booster)) {
            liftOff(booster, parent);
        } else {
            // field was user defined class
            forceLiftOff(booster, parent);
        }

    }

    // Holy Cow! This was special type of Rocket Booster, We need extra effort to start it off!
    private static void forceLiftOff(Field booster, Object parent) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // field was not any standard variable type, so we needed to initialize it with its constructor

        Object instance = booster.getType().getConstructor().newInstance();
        booster.set(parent, instance);

        // if it was a user defined class, we need to set values to its members also

        // All sub-boosters must also be started!!
        for (Field subBooster : booster.getType().getDeclaredFields()) {
            // Goooo!!!!!!!!!
            ignite(subBooster, instance);
        }
    }

    // 3, 2, 1.... and Lift Off!!
    private static void liftOff(Field booster, Object parent) throws IllegalAccessException {
        // set field accessible!
        booster.setAccessible(true);

        // assign value with respect to type
        if (booster.getType().isAssignableFrom(int.class)) {
            booster.set(parent, 23);
        }
        if (booster.getType().isAssignableFrom(long.class)) {
            booster.set(parent, 24L);
        }
        if (booster.getType().isAssignableFrom(boolean.class)) {
            booster.set(parent, false);
        }
        if (booster.getType().isAssignableFrom(char.class)) {
            booster.set(parent, 'c');
        }
        if (booster.getType().isAssignableFrom(double.class)) {
            booster.set(parent, 25D);
        }
        if (booster.getType().isAssignableFrom(float.class)) {
            booster.set(parent, 25F);
        }
        if (booster.getType().isAssignableFrom(byte.class)) {
            booster.set(parent, 26);
        }
        if (booster.getType().isAssignableFrom(short.class)) {
            booster.set(parent, 21);
        }
        if (booster.getType().isAssignableFrom(String.class)) {
            booster.set(parent, "sampleString");
        }


    }

    // Check whether it is standard Falcon 9 Rocket booster or not!
    private static boolean isStandardBooster(Field booster) {
        // if the field is of java primitive type or String type we can safely set values
        return booster.getType().isAssignableFrom(byte.class)
                || booster.getType().isAssignableFrom(short.class)
                || booster.getType().isAssignableFrom(int.class)
                || booster.getType().isAssignableFrom(float.class)
                || booster.getType().isAssignableFrom(long.class)
                || booster.getType().isAssignableFrom(double.class)
                || booster.getType().isAssignableFrom(boolean.class)
                || booster.getType().isAssignableFrom(char.class)
                || booster.getType().isAssignableFrom(String.class) ;
    }


}
