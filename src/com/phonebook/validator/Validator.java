package com.phonebook.validator;

import com.phonebook.exception.IncorrectInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Pattern regexPattern;
    private static Matcher regMatcher;

    public static boolean nameSurnameValidation(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("^[A-ZА-ЯІ][a-z-а-яії]{1,15}",Pattern.UNICODE_CHARACTER_CLASS);
        regMatcher   = regexPattern.matcher(str);
        if(regMatcher.matches()) {
            return true;
        } else {
            throw new IncorrectInputException("Incorrectly input Text.");
        }
    }

    public static boolean phoneNumberValidation(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("^\\+38[0-9]{9,11}$");
        regMatcher   = regexPattern.matcher(str);
        if(regMatcher.matches()) {
            return true;
        } else {
            throw new IncorrectInputException("Incorrectly input mobile number");
        }
    }

    public static boolean idValidation(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("^[0-9]{1,10}$");
        regMatcher   = regexPattern.matcher(str);
        if(regMatcher.matches()) {
            return true;
        } else {
            throw new IncorrectInputException("Incorrectly input id");
        }
    }
}
