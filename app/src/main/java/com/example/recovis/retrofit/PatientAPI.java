package com.example.recovis.retrofit;

import com.example.recovis.model.Patient;

import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PatientAPI {

    @GET("/patient/get-patient")
    Call<Patient> getProfile(@Query("username") String username, @Query("password") String password);
}
