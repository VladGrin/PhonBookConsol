package com.phonebook.repository.impl;

import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;

import java.util.HashMap;
import java.util.Map;

public class PersonRepositoryMap implements PersonRepository {

    private Map<Integer, Person> personMap = new HashMap<>();
    private int id = 1;

    @Override
    public boolean createPerson(Person person) {
        personMap.put(id, person);
        person.setId(id++);
        return true;
    }

    @Override
    public String showAllPerson() {
        String string = "";
        for (Map.Entry<Integer, Person> entry: personMap.entrySet()){
            string += entry.getKey() + " " + entry.getValue() + "\n";
        }
        return string;
    }

    @Override
    public String showNumberByName(String name) {
        String string = "";
        for (Map.Entry<Integer, Person> entry: personMap.entrySet()){
            if (entry.getValue().getSurname().equals(name)){
                string += entry.getKey() + " " + entry.getValue() + "\n";
            }
        }
        return string;
    }

    @Override
    public String showPersonByNumber(String number) {
        String string = "";
        for (Map.Entry<Integer, Person> entry: personMap.entrySet()){
            if (entry.getValue().getPhoneNumber().equals(number)){
                string += entry.getKey() + " " + entry.getValue() + "\n";
            }
        }
        return string;
    }

    @Override
    public boolean updatePerson(Person person) {
        for (Map.Entry<Integer, Person> entry: personMap.entrySet()){
            if (entry.getKey().equals(person.getId())){
                personMap.put(entry.getKey(), person);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        for (Map.Entry<Integer, Person> entry: personMap.entrySet()){
            if (entry.getKey().equals(id)){
                personMap.remove(id);
                return true;
            }
        }
        return false;
    }
}
