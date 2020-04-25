package com.example.admin.nycshcool.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    static Retrofit retrofitInstance;

    public static final String BASE_URL = "https://data.cityofnewyork.us/resource/";
//97mf-9njv.json


    public RetrofitInstance(Retrofit retrofitInstance) {
        this.retrofitInstance = retrofitInstance;

    }

    public static Retrofit getRetrofitInstance()
    {
        if(retrofitInstance == null)
        {

            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitInstance;
    }

    public GetSchoolService GSS()
    {
        return retrofitInstance.create(GetSchoolService.class);
    }

    public GetSATService GSATS(){ return  retrofitInstance.create(GetSATService.class);}
}
