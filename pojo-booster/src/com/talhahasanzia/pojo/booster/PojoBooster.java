package com.talhahasanzia.pojo.booster;

import com.talhahasanzia.pojo.annotation.Boost;
import com.talhahasanzia.pojo.annotation.StringValue;
import com.talhahasanzia.pojo.annotation.TestValue;
import com.talhahasanzia.pojo.annotation.Unsigned;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

/**
 * Course set to Martian Orbit!
 */
public final class PojoBooster {


    // T-10 seconds to lift off, checking all engines...
    public static void boost(Object parent) {

        System.out.println("Please subscribe to PewDiePie and lets beat T-Series! \uD83D\uDC4A \uD83D\uDC4A");

        // now lets start

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

        if (booster.getType().isAssignableFrom(byte.class) || booster.getType().isAssignableFrom(Byte.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for byte type
                byte testValue = booster.getAnnotation(TestValue.class).byteValue();
                booster.set(parent, testValue);

            } else if (booster.isAnnotationPresent(Unsigned.class)) {
                // user marked this field as unsigned, meaning no negative value
                booster.set(parent, getByte(0));
            } else {
                // by default, generate a random value
                booster.set(parent, getByte(Byte.MIN_VALUE));
            }
        }

        if (booster.getType().isAssignableFrom(short.class) || booster.getType().isAssignableFrom(Short.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for short type
                short testValue = booster.getAnnotation(TestValue.class).shortValue();
                booster.set(parent, testValue);

            } else if (booster.isAnnotationPresent(Unsigned.class)) {
                // user marked this field as unsigned, meaning no negative value
                booster.set(parent, getShort(0));
            } else {
                // by default, generate a random value
                booster.set(parent, getShort(Short.MIN_VALUE));
            }
        }


        if (booster.getType().isAssignableFrom(int.class) || booster.getType().isAssignableFrom(Integer.class)) {

            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for int type
                int testValue = booster.getAnnotation(TestValue.class).intValue();
                booster.set(parent, testValue);

            } else if (booster.isAnnotationPresent(Unsigned.class)) {
                // user marked this field as unsigned, meaning no negative value
                booster.set(parent, getInteger(0));
            } else {
                // by default, generate a random value
                booster.set(parent, getInteger(Integer.MIN_VALUE));
            }
        }

        if (booster.getType().isAssignableFrom(long.class) || booster.getType().isAssignableFrom(Long.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for long type
                long testValue = booster.getAnnotation(TestValue.class).longValue();
                booster.set(parent, testValue);

            } else if (booster.isAnnotationPresent(Unsigned.class)) {
                // user marked this field as unsigned, meaning no negative value
                booster.set(parent, getLong(0));
            } else {
                // by default, generate a random value
                booster.set(parent, getLong(Long.MIN_VALUE));
            }
        }

        if (booster.getType().isAssignableFrom(double.class) || booster.getType().isAssignableFrom(Double.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for double type
                double testValue = booster.getAnnotation(TestValue.class).doubleValue();
                booster.set(parent, testValue);

            } else if (booster.isAnnotationPresent(Unsigned.class)) {
                // user marked this field as unsigned, meaning no negative value
                booster.set(parent, getDouble(0));
            } else {
                // by default, generate a random value
                booster.set(parent, getDouble(Double.MIN_VALUE));
            }
        }

        if (booster.getType().isAssignableFrom(float.class) || booster.getType().isAssignableFrom(Float.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for float type
                float testValue = booster.getAnnotation(TestValue.class).floatValue();
                booster.set(parent, testValue);

            } else if (booster.isAnnotationPresent(Unsigned.class)) {
                // user marked this field as unsigned, meaning no negative value
                booster.set(parent, getFloat(0));
            } else {
                // by default, generate a random value
                booster.set(parent, getFloat(Float.MIN_VALUE));
            }
        }


        if (booster.getType().isAssignableFrom(boolean.class) || booster.getType().isAssignableFrom(Boolean.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for boolean type
                boolean testValue = booster.getAnnotation(TestValue.class).booleanValue();
                booster.set(parent, testValue);

            } else {
                // by default, generate a random value
                booster.set(parent, getBoolean());
            }
        }

        if (booster.getType().isAssignableFrom(char.class) || booster.getType().isAssignableFrom(Character.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for character (char) type
                char testValue = booster.getAnnotation(TestValue.class).characterValue();
                booster.set(parent, testValue);

            } else {
                // by default, generate a random value
                booster.set(parent, getCharacter());
            }
        }


        if (booster.getType().isAssignableFrom(String.class)) {
            // user provided test value
            if (booster.isAnnotationPresent(TestValue.class)) {
                // get user provided test value for string type
                String testValue = booster.getAnnotation(TestValue.class).stringValue();
                booster.set(parent, testValue);

            } else {
                // by default, generate a random value'
                if (booster.isAnnotationPresent(StringValue.class)) {
                    int testLength = booster.getAnnotation(StringValue.class).length();

                } else {
                    booster.set(parent, getString(8, -1));
                }

            }
        }

    }

    private static short getShort(int min) {
        return (short) ((Math.random()) * (Short.MAX_VALUE - min) + min);
    }

    private static byte getByte(int min) {
        // byte max value is 127
        return (byte) ((Math.random()) * (127 - min) + min);
    }

    private static float getFloat(float min) {
        return (float) ((Math.random()) * (Float.MAX_VALUE - min) + min);
    }

    private static double getDouble(double min) {
        return (Math.random()) * (Double.MAX_VALUE - min) + min;
    }

    private static boolean getBoolean() {
        return false;
    }

    private static long getLong(long min) {
        return (long) ((Math.random()) * (Long.MAX_VALUE - min) + min);
    }

    private static int getInteger(int min) {
        return (int) ((Math.random()) * (Integer.MAX_VALUE - min) + min);
    }

    private static char getCharacter() {
        return 'c';
    }

    private static String getString(int length, int flag) {
        return getNewRandomPhrase(length, flag);
    }

    public static String getNewRandomPhrase(int length, int flag) {
        Random randomizer = new Random();

        // create a random string using alphabets and characters
        char[] charactersRange = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        char[] special = "~!@#$%^&*()_+=-[]';,./<>?:\"{}|".toCharArray();

        char[] numerics = "0123456789".toCharArray();


        char[] randomData = new char[length];

        for (int i = 0; i < length - 1; i++) {

            int randomIndex = randomizer.nextInt(35 + 1);

            randomData[i] = charactersRange[randomIndex];
        }

        // fixme: string conversion
        return Arrays.toString(randomData);
    }

    // Check whether it is standard Falcon 9 Rocket booster or not!
    private static boolean isStandardBooster(Field booster) {
        // if the field is of java primitive type or String type we can safely set values
        return booster.getType().isAssignableFrom(byte.class) || booster.getType().isAssignableFrom(Byte.class)
                || booster.getType().isAssignableFrom(short.class) || booster.getType().isAssignableFrom(Short.class)
                || booster.getType().isAssignableFrom(int.class) || booster.getType().isAssignableFrom(Integer.class)
                || booster.getType().isAssignableFrom(float.class) || booster.getType().isAssignableFrom(Float.class)
                || booster.getType().isAssignableFrom(long.class) || booster.getType().isAssignableFrom(Long.class)
                || booster.getType().isAssignableFrom(double.class) || booster.getType().isAssignableFrom(Double.class)
                || booster.getType().isAssignableFrom(boolean.class) || booster.getType().isAssignableFrom(Boolean.class)
                || booster.getType().isAssignableFrom(char.class) || booster.getType().isAssignableFrom(Character.class)
                || booster.getType().isAssignableFrom(String.class);
    }


}
