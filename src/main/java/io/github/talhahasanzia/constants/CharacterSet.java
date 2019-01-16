package io.github.talhahasanzia.constants;

/**
 * Describes the set of characters that will be used in string's random generation!
 */
public interface CharacterSet {
    /**
     * All characters and numerals including special characters like ~!@#$%^&*()_+=-[]';,./<>?:"{}|
     */
    int ALL = -1;

    /**
     * All alphabets including uppercase and lowercase letters
     */
    int ALPHABETS = 0;

    /**
     * Numerals only 0-9
     */
    int NUMERALS = 1;

    /**
     * alphabets and numerals
     */
    int ALPHANUMERIC = 2;

}
