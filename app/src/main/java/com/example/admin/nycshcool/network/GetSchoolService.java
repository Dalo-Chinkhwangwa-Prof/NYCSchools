package com.example.admin.nycshcool.network;

import com.example.admin.nycshcool.data.School;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSchoolService {

    @GET("97mf-9njv.json")
    Call<ArrayList<School>> getSchools();

}
