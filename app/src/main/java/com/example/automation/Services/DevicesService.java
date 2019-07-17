package com.example.automation.Services;

import com.example.automation.models.AutoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DevicesService {

    // TODO: Definisikan service getCalories()
    @GET("/fuad99/automation/devices")
    Call<List<AutoModel>> getDevices();

    // TODO: Definisikan service addCalory()
    @POST("/fuad99/automation/devices")
    Call<AutoModel> addDevices(@Body AutoModel autoModel);

    // TODO: Definisikan service editCalory()
    @PUT("/fuad99/automation/devices")
    Call<AutoModel> editCalory(@Path("id") int id, @Body AutoModel autoModel);
}
