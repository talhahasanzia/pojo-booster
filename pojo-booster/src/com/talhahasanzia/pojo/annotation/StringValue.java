package com.talhahasanzia.pojo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringValue {
    /**
     * Length of string to be generated, defaults t0 8 characters
     * @return length
     */
    int length() default 8;

    /**
     * Allow only characters
     *
     * @return allow or not
     */
    boolean charactersOnly() default false;

    /**
     * Allow numbers only
     *
     * @return allow or not
     */
    boolean numbersOnly() default false;

    /**
     * Allow alphanumeric
     *
     * @return allow or not
     */
    boolean alphaNumeric() default false;

    /**
     * Allow special chars like ~!@#$%^&*()_+=-[]';,./<>?:"{}| with alpha numeric
     *
     * @return allow or not
     */
    boolean allowSpecial() default true;

}
