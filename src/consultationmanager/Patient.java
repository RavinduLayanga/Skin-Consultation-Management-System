package consultationmanager;

import java.time.LocalDate;

public class Patient extends Person{
    private String name;
    private String sureName;
    private LocalDate dateOfBirth;
    private String mobileNo;
    private String id;

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setSureName(String sureName) {
        this.sureName=sureName;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
    }

    @Override
    public void setMobileNo(String mobileNo) {
        this.mobileNo=mobileNo;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSureName() {
        return sureName;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getMobileNo() {
        return mobileNo;
    }

    //create setters
    public void setId(String id) {
        this.id = id;
    }

    //create getters
    public String getId() {
        return id;
    }


}
