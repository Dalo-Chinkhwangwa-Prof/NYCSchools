package com.example.admin.nycshcool.network;

import com.example.admin.nycshcool.data.SchoolDetail;
import com.example.admin.nycshcool.view.SchoolDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetSATService {

@GET("734v-jeq5.json")
    Call<ArrayList<SchoolDetail>> getSchoolDetails(@Query("dbn") String dbn);
}
