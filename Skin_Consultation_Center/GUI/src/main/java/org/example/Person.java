package org.example;

public class Person {
    protected String name;
    protected String surname;
    protected String dateOfBirth;
    protected String mobileNumber;

    Person(String name1, String surname1, String dateOfBirth1, String mobileNumber1){
        this.name = name1;
        this.surname = surname1;
        this.dateOfBirth = dateOfBirth1;
        this.mobileNumber = mobileNumber1;
    }

    public Person(String name1) {
        this.name = name1;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
