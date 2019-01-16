package io.github.talhahasanzia.booster;


import io.github.talhahasanzia.annotation.Boost;
import io.github.talhahasanzia.annotation.CharacterConfig;
import io.github.talhahasanzia.annotation.TestValue;
import io.github.talhahasanzia.annotation.Unsigned;
import io.github.talhahasanzia.constants.CharacterSet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Course set to Martian Orbit!
 * It's not rocket science!
 * (This code takes care of initializing all the annotated fields.)
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
        } else if (booster.getType().isEnum()) {
            // Enums are treated specially
            specialLiftOff(booster, parent);
        } else {
            // field was user defined class
            forceLiftOff(booster, parent);
        }

    }

    private static void liftOff(Field booster, Object parent) throws IllegalAccessException {
        // 3, 2, 1.... and Lift Off!!
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

            } else if (booster.isAnnotationPresent(CharacterConfig.class)) {

                // a configuration was present so check its values, here we only need character set values
                int characterSet = booster.getAnnotation(CharacterConfig.class).characterSet();
                booster.set(parent, getCharacter(characterSet));

            } else {
                // defaults to alphabet set
                booster.set(parent, getCharacter(CharacterSet.ALPHABETS));

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
                if (booster.isAnnotationPresent(CharacterConfig.class)) {
                    int length = booster.getAnnotation(CharacterConfig.class).length();
                    int characterSet = booster.getAnnotation(CharacterConfig.class).characterSet();
                    booster.set(parent, getString(length, characterSet));
                } else {
                    booster.set(parent, getString(8, CharacterSet.ALL));
                }

            }
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


    // for Special Enum Types
    private static void specialLiftOff(Field booster, Object parent) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        // set this to be accessible
        booster.setAccessible(true);

        List<?> list = Arrays.asList(booster.getType().getEnumConstants());
        int randomElement = getRandomIndex(list.size());


        booster.set(
                parent,
                Enum.valueOf((Class<Enum>) booster.getType(),
                        String.valueOf(list.get(randomElement))));
    }


    private static int getRandomIndex(int size) {
        return (int) ((Math.random()) * (size) + 0);
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

    private static char getCharacter(int characterSet) {
        return getRandomChar(characterSet);
    }

    private static char getRandomChar(int characterSet) {
        char[] charSet = getAllowedCharacterSet(characterSet);

        int randomIndex = new Random().nextInt((charSet.length - 1) + 1);


        return charSet[randomIndex];
    }

    private static String getString(int length, int characterSet) {
        return getNewRandomPhrase(length, characterSet);
    }

    private static String getNewRandomPhrase(int length, int characterSet) {
        Random randomizer = new Random();


        char[] allowedCharacters = getAllowedCharacterSet(characterSet);

        char[] randomData = new char[length];

        for (int i = 0; i < length; i++) {

            int randomIndex = randomizer.nextInt((allowedCharacters.length - 1) + 1);

            randomData[i] = allowedCharacters[randomIndex];
        }

        return String.valueOf(randomData);
    }

    private static char[] getAllowedCharacterSet(int flag) {

        char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        char[] numerals = "0123456789".toCharArray();

        char[] special = "~!@#$%^&*()_+=-[]';,./<>?:\"{}|".toCharArray();

        char[] characterSet = new char[0];

        if (flag == CharacterSet.ALL) {
            characterSet = new char[numerals.length + special.length + characters.length];
            // combine all 3 sets
            System.arraycopy(characters, 0, characterSet, 0, characters.length);
            System.arraycopy(numerals, 0, characterSet, characters.length, numerals.length);
            System.arraycopy(special, 0, characterSet, numerals.length + characters.length, special.length);


        } else if (flag == CharacterSet.ALPHABETS) {
            // only alphabets
            characterSet = characters;

        } else if (flag == CharacterSet.ALPHANUMERIC) {
            // alphanumeric characters
            characterSet = new char[numerals.length + characters.length];
            // combine these two
            System.arraycopy(characters, 0, characterSet, 0, characters.length);
            System.arraycopy(numerals, 0, characterSet, characters.length, numerals.length);

        } else if (flag == CharacterSet.NUMERALS) {
            // only numbers
            characterSet = numerals;
        }


        return characterSet;
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
