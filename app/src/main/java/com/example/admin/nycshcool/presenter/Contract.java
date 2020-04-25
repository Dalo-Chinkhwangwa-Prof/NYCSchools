package com.example.admin.nycshcool.presenter;

import com.example.admin.nycshcool.data.School;
import com.example.admin.nycshcool.data.SchoolDetail;

import java.util.ArrayList;

public interface Contract {


    public interface View
    {

        public void displaySchools(ArrayList<School> schools);


    }

    public interface SchoolInfo
    {
        public void displaySchoolInfo(SchoolDetail schoolDetail);
        public void noInfo();
    }

    public interface Presenter
    {
        public void getSchools();
        public void getSchoolInfo(String name);
        public void attachView(Contract.View view);
    }

}
