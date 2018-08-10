package com.example.denis.basicretrofitexampleapp.network;

import com.example.denis.basicretrofitexampleapp.CurrencyData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataServices {

    @GET("/api/v1/rates/daily")
    Call<List<CurrencyData>> getAllCurrency();
}
