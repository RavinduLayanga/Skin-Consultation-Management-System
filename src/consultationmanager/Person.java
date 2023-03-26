package consultationmanager;

import java.time.LocalDate;

public abstract class Person {
//    private String name;
//
    //Create setters
    public abstract void setName(String name);
    public abstract void setSureName(String sureName);
    public abstract void setDateOfBirth(LocalDate dateOfBirth);
    public abstract void setMobileNo(String mobileNo);

    //create getters
    public abstract String getName();
    public abstract String getSureName();
    public abstract LocalDate getDateOfBirth();
    public abstract String getMobileNo();




}
