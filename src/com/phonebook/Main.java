package com.phonebook;

import com.phonebook.exception.IncorrectInputException;
import com.phonebook.service.impl.PersonServiceBook;

public class Main {

    public static void main(String[] args) throws IncorrectInputException {
         PersonServiceBook.start();

    }
}
