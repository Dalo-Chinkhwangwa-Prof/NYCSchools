package com.example.admin.nycshcool.di.component;

import com.example.admin.nycshcool.di.module.SchoolModule;
import com.example.admin.nycshcool.presenter.ActivityPresenter;
import com.example.admin.nycshcool.presenter.Contract;
import com.example.admin.nycshcool.view.MainActivity;
import com.example.admin.nycshcool.view.SchoolDetails;

import dagger.Component;

//Step 2: Create contract for dependencies and dependent

@Component(modules = SchoolModule.class)
public interface SchoolComponent {

    //Target for dependencies
    //Target 1
    void inject(MainActivity activity);

}
