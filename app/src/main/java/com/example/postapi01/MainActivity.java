package com.example.postapi01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;
import java.util.concurrent.Delayed;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    AfInterface afInterface;
    AFadapter aFadapter;
    Retrofit retrofit;
    Button bt, bt1;
    int count;
    ProgressBar progressBar;
    CardView cardView;
    List<Afmodel> afmodels;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        bt = findViewById(R.id.nx);
        bt1 = findViewById(R.id.bk);
        cardView = findViewById(R.id.cd);
        dialog();

    }

    //Progress dialog
    void dialog() {
        bt1.setVisibility(View.GONE);
        bt.setVisibility(View.GONE);
        progressBar = findViewById(R.id.pg);
        progressBar.setVisibility(View.VISIBLE);
        allmethod();

    }

    //Calling API data
    void allmethod() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://phplaravel-882494-3459554.cloudwaysapps.com/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        afInterface = retrofit.create(AfInterface.class);
        Call<List<Afmodel>> request = afInterface.getAf();
        request.enqueue(new Callback<List<Afmodel>>() {
            @Override
            public void onResponse(Call<List<Afmodel>> call, Response<List<Afmodel>> response) {
                aFadapter = new AFadapter(MainActivity.this, response.body().subList(0, 10));
                adapt();
                progressBar.setVisibility(View.GONE);
                bt.setVisibility(View.VISIBLE);
                bt1.setVisibility(View.GONE);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (count == 0) {
                            aFadapter = new AFadapter(MainActivity.this, response.body().subList(10, 20));
                            adapt();
                            bt1.setVisibility(View.VISIBLE);
                            Log.e("TAG", "onResponse: " + response.body().size());
                            count++;
                        } else if (count == 1) {
                            aFadapter = new AFadapter(MainActivity.this, response.body().subList(20, 21));
                            adapt();
                            bt.setVisibility(View.GONE);

                        }
                    }
                });
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (count == 1) {
                            aFadapter = new AFadapter(MainActivity.this, response.body().subList(11, 21));
                            adapt();
                            bt1.setVisibility(View.VISIBLE);
                            bt.setVisibility(View.VISIBLE);
                            Log.e("TAG", "onResponse: " + response.body().size());
                            count++;
                        } else if (count == 2) {
                            aFadapter = new AFadapter(MainActivity.this, response.body().subList(0, 11));
                            adapt();
                            bt.setVisibility(View.VISIBLE);
                            bt1.setVisibility(View.GONE);
                            count=0;
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Afmodel>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    //Calling Adapter
    void adapt() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(aFadapter);


    }
}
