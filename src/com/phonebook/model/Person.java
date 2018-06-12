package com.phonebook.model;

public class Person {
    private String id;
    private String surname;
    private String phoneNumber;

    public Person(Builder builder) {
        this.id = builder.id;
        this.surname = builder.surname;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return surname + " " + phoneNumber;
    }

    public static class Builder{
        private String id;
        private String surname;
        private String phoneNumber;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
