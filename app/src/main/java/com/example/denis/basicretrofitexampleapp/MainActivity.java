package com.example.denis.basicretrofitexampleapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.denis.basicretrofitexampleapp.network.GetDataServices;
import com.example.denis.basicretrofitexampleapp.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UpdateUi();
    }

    private void UpdateUi() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataServices services = RetrofitClientInstance.getRetrofitInstance().create(GetDataServices.class);
        Call<List<CurrencyData>> call = services.getAllCurrency();

        call.enqueue(new Callback<List<CurrencyData>>() {
            @Override
            public void onResponse(Call<List<CurrencyData>> call, Response<List<CurrencyData>> response) {
                progressDialog.dismiss();

                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<CurrencyData>> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<CurrencyData> currencyData) {
        mRecyclerView = findViewById(R.id.currrency_recyclerview);
        mAdapter = new CustomAdapter(this, currencyData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
