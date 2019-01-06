package com.talhahasanzia.pojo.annotation;

import com.talhahasanzia.pojo.constants.CharacterSet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CharacterConfig {
    /**
     * Length of string to be generated, defaults t0 8 characters
     *
     * @return length
     */
    int length() default 8;

    /**
     * Describes the set of characters that will be used in string's random generation!
     * Must be of type {@link CharacterSet}
     */
    int characterSet() default CharacterSet.ALL;

}
