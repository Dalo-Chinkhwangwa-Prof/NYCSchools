package com.example.admin.nycshcool.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.nycshcool.R;
import com.example.admin.nycshcool.adapter.MyRVAdapter;
import com.example.admin.nycshcool.data.School;
import com.example.admin.nycshcool.di.component.DaggerSchoolComponent;
import com.example.admin.nycshcool.presenter.ActivityPresenter;
import com.example.admin.nycshcool.presenter.Contract;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private RecyclerView myRView;
    private MyRVAdapter myRVAdapter;

    //Step 4 : Inject the presenter
    @Inject
    ActivityPresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 3 : initialize dagger component
        DaggerSchoolComponent
                .create()
                .inject(this);

        myPresenter.attachView(this);

        myRView = findViewById(R.id.myRView);
        myPresenter.getSchools();

    }

    @Override
    public void displaySchools(ArrayList<School> schools) {

        myRVAdapter = new MyRVAdapter(schools);
        myRView.setLayoutManager(new LinearLayoutManager(this));
        myRView.setAdapter(myRVAdapter);

    }
}
