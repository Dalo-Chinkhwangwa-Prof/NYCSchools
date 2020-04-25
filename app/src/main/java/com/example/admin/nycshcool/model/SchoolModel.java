package com.example.admin.nycshcool.model;

public class SchoolModel {

    private static SchoolModel instance = null;


    String schoolName;
    String schoolCity;
    String faxNumber;
    String phoneNumber;

    private SchoolModel()
    {

    }

    public static SchoolModel getInstance()
    {
        if(instance == null)
        {
            instance = new SchoolModel();

        }

        return  instance;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
