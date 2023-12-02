package com.example.recovis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recovis.databinding.ActivityLoginBinding;
import com.example.recovis.databinding.ActivityMainBinding;
import com.example.recovis.model.Patient;
import com.example.recovis.retrofit.PatientAPI;
import com.example.recovis.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String loginStatus = sharedPreferences.getString(getResources().getString(R.string.loggedInStatus), "");
        if (loginStatus.equals("loggedin")) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        RetrofitService retrofitService = new RetrofitService();
        PatientAPI patientAPI = retrofitService.getRetrofit().create(PatientAPI.class);




        binding.login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if (username.isEmpty()) {
                    binding.username.setBackgroundColor(Color.RED);
                }
                if (password.isEmpty()) {
                    binding.password.setBackgroundColor(Color.RED);
                }
                if (!username.isEmpty() && !password.isEmpty()) {
                    patientAPI.getProfile(username, password).enqueue(new Callback<Patient>() {
                        @Override
                        public void onResponse(Call<Patient> call, Response<Patient> response) {
                            Patient p = response.body();
                            if(p == null)
                            {
                                Toast toast = Toast.makeText(LoginActivity.this, "Wrong credentials!", Toast.LENGTH_LONG);
                                toast.show();
                            }
                            else
                            {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            }
                        }
                        @Override
                        public void onFailure(Call<Patient> call, Throwable t) {
                            Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, t.toString());
                        }
                    });
                }
            }
        });
    }
}
