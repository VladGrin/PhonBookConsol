package com.phonebook.model;

public class Person {
    private int id = 0;
    private String surname;
    private String phoneNumber;

    public Person(int id, String surname, String phoneNumber) {
        this.id = id;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }
    public Person(String surname, String phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return surname + " " + phoneNumber;
    }
}
