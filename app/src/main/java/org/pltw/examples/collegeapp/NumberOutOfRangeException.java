package org.pltw.examples.collegeapp;

public class NumberOutOfRangeException extends RuntimeException {
    public NumberOutOfRangeException(String message){
        super(message);
    }

    public static String joinMessageAndYear(String message, int year){
        Integer yearBoxed = year;
        message = message + " " + yearBoxed.toString();
        return message;
    }
}
