package com.phonebook.repository.impl;

import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;

import java.io.*;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public boolean createPerson(Person person) {
        String line = null, lastLine = "";
        int idLast;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ((line = bufferedReader.readLine()) != null){
                lastLine = line;
            }
            idLast =  (lastLine == "") ?  0 : Integer.parseInt(lastLine.split(" ")[0]);
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("datafile.txt", true));
            if (idLast == 0){
                bufferedWriter.write((idLast + 1) + " " + person);
            } else {
                bufferedWriter.write("\n" + (idLast + 1) + " " + person);
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String showAllPerson() {
        String string = "", line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                string += line + "\n" ;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    @Override
    public String showNumberByName(String name) {
        String string = "", line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                if(line.split(" ")[1].equals(name)){
                    string += line + "\n" ;
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    @Override
    public String showPersonByNumber(String number) {
        String string = "", line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                if(line.split(" ")[2].equals(number)){
                    string += line + "\n" ;
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    @Override
    public boolean updatePerson(Person person) {
        String string = "", line;
        int index = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            while ( (line = bufferedReader.readLine()) != null){
                if(line.split(" ")[0].equals(String.valueOf(person.getId()))){
                    string += ( index == 0 ) ? person.getId() + " " + person.toString() + "\n" :
                            "\n" + person.getId() + " " + person.toString();
                    System.out.println("1");
                } else {
                    string += (index++ == 0) ? line : "\n" + line;
                    System.out.println("2");
                }
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("datafile.txt", true));
            bufferedWriter.write(string);
            bufferedWriter.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        String string="", line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datafile.txt"));
            int index = 0;
            while ( (line = bufferedReader.readLine()) != null){
                if(Integer.parseInt(line.split(" ")[0]) == id){
                    continue;
                }
                string += (index++ == 0) ? line : "\n" + line;
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("datafile.txt"));
            bufferedWriter.write(string);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
