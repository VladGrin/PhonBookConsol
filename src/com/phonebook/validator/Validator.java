package com.phonebook.validator;

import com.phonebook.exception.IncorrectInputException;

public class Validator {

    public static boolean nameSurnameValidation(String string) throws IncorrectInputException {
        int count = 0;
        int flag;
        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'
                ,'t','u','v','w','x','y','z','A','B','C','D','I','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'
                ,'T','U','V','W','X','Y','Z','-'};
        for (int i = 0; i < string.length(); i++){
            flag = 0;
            for (char letter : letters){
                if ( string.charAt(i) == letter ){
                    flag = 1;
                    break;
                }
            }
            count++;
            if (flag != 1)
                throw new IncorrectInputException("Incorrectly input litter");
        }
        if ( count < 1 || count > 40)
            throw new IncorrectInputException("Wrong number of letters entered");
        return true;
    }

    public static boolean phoneNumberValidation(String string) throws IncorrectInputException {
        int flag;
        int count = 0;
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < string.length(); i++){
            flag = 0;
            for (char number : numbers){
                if ( string.charAt(i) == number ){
                    flag = 1;
                    break;
                }
            }
            count++;
            if (flag != 1)
                throw new IncorrectInputException("Incorrectly input number");
        }
        if ( count < 11 || count > 12)
            throw new IncorrectInputException("Incorrect number of digits entered");
        return true;
    }
}
