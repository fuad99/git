package com.example.automation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.automation.Adapters.AutoAdapter;
import com.example.automation.Services.DevicesService;
import com.example.automation.models.AutoModel;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements
        CardFragment.OnFragmentInteractionListener
         {
    TextView tv;
    DevicesService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvUser);




        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null){
            fragment=new CardFragment();
            fm.beginTransaction().add(R.id.fragmentContainer,fragment).commit();



        }

    }

             @Override
             public void onCaloryFragmentCreated(final View view, final AutoAdapter adapter) {
                 Call<List<AutoModel>> devicesCall = service.getDevices();
                 devicesCall.enqueue(new Callback<List<AutoModel>>() {
                     @Override
                     public void onResponse(Call<List<AutoModel>> call, Response<List<AutoModel>> response) {
                         List<AutoModel> list = response.body();
                         adapter.setDevices(list);


                     }
                     @Override
                     public void onFailure(Call<List<AutoModel>> call, Throwable t) {
                         Snackbar.make(view,"Ooops! Data Gagal Diambil",Snackbar.LENGTH_LONG).show();
                     }
             });
             }

         }
