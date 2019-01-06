package com.talhahasanzia;

import com.talhahasanzia.pojo.annotation.CharacterConfig;
import com.talhahasanzia.pojo.annotation.TestValue;
import com.talhahasanzia.pojo.annotation.Unsigned;
import com.talhahasanzia.pojo.constants.CharacterSet;

public class Sample {

    @Unsigned
    private int userId;

    private char userType;

    @TestValue(longValue = 33)
    private long sign;

    private short someShort;

    @Unsigned
    private byte someByte;

    private Double someDouble;
    private float someFloat;
    private Integer boxInt;

    @CharacterConfig(length = 10, characterSet = CharacterSet.ALPHABETS)
    private String userName;


    public Sample() {
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public char getUserType() {
        return userType;
    }

    public long getSign() {
        return sign;
    }

    public short getSomeShort() {
        return someShort;
    }

    public byte getSomeByte() {
        return someByte;
    }

    public Double getSomeDouble() {
        return someDouble;
    }

    public float getSomeFloat() {
        return someFloat;
    }

    public Integer getBoxInt() {
        return boxInt;
    }

    @Override
    public String toString() {
        return "UserId: " + userId + ", UserType: " + userType + ", User Sign: " + sign + ", UserName: " + userName
                + "\nSomeShort: " + someShort;
    }
}
