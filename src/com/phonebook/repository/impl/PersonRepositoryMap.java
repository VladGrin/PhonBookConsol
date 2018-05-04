package com.phonebook.repository.impl;

import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;

import java.util.HashMap;
import java.util.Map;

public class PersonRepositoryMap implements PersonRepository {

    private static Map<Integer, Person> personMap = new HashMap<>();
    private int id = 0;

    @Override
    public boolean create(Person person) {
        personMap.put(id, person);
        person.setId(id++);
        return true;
    }

    @Override
    public String outputPhoneNumber(String string){
        for (int i = 0; i < personMap.size(); i++) {
            if (personMap.get(i).getSurname().equals(string))
                return personMap.get(i).getPhoneNumber();
        }
        return  "There is no such subscriber";
    }

    @Override
    public String outputSurname(String string){
        for (int i = 0; i < personMap.size(); i++) {
            if (personMap.get(i).getPhoneNumber().equals(string))
                return personMap.get(i).getSurname();
        }
        return  "There is no such phone number";
    }


    @Override
    public Person read(int id) {
        return personMap.get(id);
    }

    @Override
    public boolean update(Person person) {
        personMap.put(person.getId(), person);
        return true;
    }

    @Override
    public boolean delete(int id) {
        personMap.remove(id);
        return true;
    }

    @Override
    public boolean delete(Person person) {
        personMap.remove(person.getId());
        return true;
    }

    public static void size(){
        System.out.println(personMap.size());;
    }
}
