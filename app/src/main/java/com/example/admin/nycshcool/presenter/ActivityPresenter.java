package com.example.admin.nycshcool.presenter;

import android.util.Log;

import com.example.admin.nycshcool.data.School;
import com.example.admin.nycshcool.data.SchoolDetail;
import com.example.admin.nycshcool.network.GetSATService;
import com.example.admin.nycshcool.network.GetSchoolService;
import com.example.admin.nycshcool.network.RetrofitInstance;
import com.example.admin.nycshcool.view.MainActivity;
import com.example.admin.nycshcool.view.SchoolDetails;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Response;

public class ActivityPresenter implements Contract.Presenter {

    private GetSchoolService GSS;
    private GetSATService GSATS;


    public static final String TAG = "TAG_";

    Contract.View view;
    Contract.SchoolInfo schoolInfo;


    public ActivityPresenter(Contract.View view) {
        this.view = view;

    }
    public ActivityPresenter(Contract.SchoolInfo schoolInfo) {
        this.schoolInfo = schoolInfo;
    }
    @Override
    public void getSchools() {

        GSS = new RetrofitInstance(RetrofitInstance.getRetrofitInstance()).GSS();

        GSS.getSchools().enqueue(new retrofit2.Callback<ArrayList<School>>() {
            @Override
            public void onResponse(Call<ArrayList<School>> call, Response<ArrayList<School>> response) {

                Log.d(TAG, "onResponse: "+response.body().size());
                view.displaySchools(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<School>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t+" url "+call.request().url().toString());
            }
        });
    }


    @Override
    public void getSchoolInfo(String dbn) {

        GSATS = new RetrofitInstance(RetrofitInstance.getRetrofitInstance()).GSATS();

        GSATS.getSchoolDetails(dbn).enqueue(new retrofit2.Callback<ArrayList<SchoolDetail>>() {
            @Override
            public void onResponse(Call<ArrayList<SchoolDetail>> call, Response<ArrayList<SchoolDetail>> response) {

                Log.d(TAG, "onResponse: "+"success "+call.request().url().toString());

                if(response.body().size() > 0) {
                    schoolInfo.displaySchoolInfo(response.body().get(0));
                }
                else
                {
                    schoolInfo.noInfo();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<SchoolDetail>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });

    }

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }
}