package com.youxiang8727.peronatw;

import retrofit2.Retrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private static ApiManager INSTANCE;
    private ApiService apiService;

    private ApiManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opendata.cwb.gov.tw/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public synchronized static ApiManager getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new ApiManager();
        }
        return INSTANCE;
    }

    public ApiService getApiService(){
        return apiService;
    }
}
