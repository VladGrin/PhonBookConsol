package com.phonebook.validator;

import com.phonebook.exception.IncorrectInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Pattern regexPattern;
    private static Matcher regMatcher;

    public static void validateText(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("[A-ZА-ЯІ][a-z-а-яії]{1,15}", Pattern.UNICODE_CHARACTER_CLASS);
        if (!regexPattern.matcher(str).matches()) {
            throw new IncorrectInputException("Incorrectly input text");
        }
    }

    public static void validateNumber(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("[1-9][0-9]{0,15}", Pattern.UNICODE_CHARACTER_CLASS);
        if (!regexPattern.matcher(str).matches()) {
            throw new IncorrectInputException("Incorrectly input number");
        }
    }

    public static void validatePhoneNumber(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("\\+[1-9][0-9]{0,15}", Pattern.UNICODE_CHARACTER_CLASS);
        if (!regexPattern.matcher(str).matches()) {
            throw new IncorrectInputException("Incorrectly input phone number");
        }
    }
}
