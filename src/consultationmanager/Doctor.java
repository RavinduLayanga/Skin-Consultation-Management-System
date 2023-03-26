package consultationmanager;

import java.time.LocalDate;

public class Doctor extends Person {
    private String name;
    private String sureName;
    private LocalDate dateOfBirth;
    private String mobileNo;
    private String medicalLicence;
    private String specialisation;

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

    //Create setters
    public void setMedicalLicence(String medicalLicence){
        this.medicalLicence=medicalLicence;
    }
    public void setSpecialisation(String specialisation){
        this.specialisation=specialisation;
    }

    //Create Getters
    public String getMedicalLicence(){
        return medicalLicence;
    }
    public String getSpecialisation(){
        return (specialisation);
    }

    //Create constructor

    public Doctor(String name, String sureName, LocalDate dateOfBirth, String mobileNo, String medicalLicence, String specialisation) {
        this.name = name;
        this.sureName = sureName;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
        this.medicalLicence = medicalLicence;
        this.specialisation = specialisation;
    }
}
