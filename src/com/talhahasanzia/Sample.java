package com.talhahasanzia;

public class Sample {

    private int userId;
    private char userType;
    private long sign;
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

    @Override
    public String toString() {
        return "UserId: " + userId + ", UserType: " + userType + ", User Sign: " + sign + ", UserName: " + userName;
    }
}
