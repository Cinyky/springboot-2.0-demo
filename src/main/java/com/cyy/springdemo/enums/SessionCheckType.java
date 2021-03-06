package com.cyy.springdemo.enums;

public enum SessionCheckType {
    /**
     * equals
     */
    EQUAL(0),
    /**
     * contains
     */
    CONTAIN(1);

    private int value;

    SessionCheckType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SessionCheckType getByValue(int value) {
        SessionCheckType type = null;
        SessionCheckType[] values = values();
        if (value >= 0 && value < values.length) {
            for (SessionCheckType sessionCheckType : values) {
                if (sessionCheckType.value == value) {
                    type = sessionCheckType;
                    break;
                }
            }
        }
        return type;
    }

}
