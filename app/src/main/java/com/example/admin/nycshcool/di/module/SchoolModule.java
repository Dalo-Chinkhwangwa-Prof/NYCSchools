package com.example.admin.nycshcool.di.module;

import android.util.Log;

import com.example.admin.nycshcool.data.School;
import com.example.admin.nycshcool.data.SchoolDetail;
import com.example.admin.nycshcool.presenter.ActivityPresenter;
import com.example.admin.nycshcool.presenter.Contract;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

//Step1: Add dependencies to module
@Module
public class SchoolModule {

    @Provides
    ActivityPresenter providesActivityPresenter(Contract.View view)
    {
        return new ActivityPresenter(view);
    }

    @Provides
    Contract.View providesContractView()
    {
        return new Contract.View() {
            @Override
            public void displaySchools(ArrayList<School> schools) {

            }
        };
    }






}
