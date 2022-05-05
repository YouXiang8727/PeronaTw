package com.youxiang8727.peronatw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.ic_android_black_200dp));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(recyclerViewAdapter);

        getApiResult();
    }

    private void initView(){
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void getApiResult(){
        ApiService apiService = ApiManager.getINSTANCE().getApiService();
        Call<ApiResult> call = apiService.getData("CWB-B3C5C1B7-F3FD-43F8-9CD7-401ABD0080D7",
                null,
                null,
                null,
                new String[]{"臺北市"},
                new String[]{"MinT"},
                null,
                null,
                null);
        call.enqueue(new Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {
                Log.d(TAG, String.valueOf(response.code()));
                if (response.code() == 200){
                    Log.d(TAG, new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                    ApiResult apiResult = response.body();
                    recyclerViewAdapter.setList(apiResult);
                }
                call.cancel();
            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}