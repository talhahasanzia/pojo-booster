package io.github.talhahasanzia;

import io.github.talhahasanzia.annotation.CharacterConfig;
import io.github.talhahasanzia.annotation.TestValue;
import io.github.talhahasanzia.annotation.Unsigned;
import io.github.talhahasanzia.constants.CharacterSet;

public class SampleDto {

    @CharacterConfig(length = 10, characterSet = CharacterSet.NUMERALS)
    String name;

   @TestValue( intValue = 33)
    int id;

    @Unsigned
    short age;

}
