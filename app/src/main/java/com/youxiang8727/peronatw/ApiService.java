package com.youxiang8727.peronatw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/rest/datastore/F-C0032-001")
    Call<ApiResult> getData(@NonNull @Query("Authorization") String authorization,
                            @Nullable @Query("limit") Integer limit,
                            @Nullable @Query("offset") Integer offset,
                            @Nullable @Query("format") String format,
                            @Nullable @Query("locationName") String[] locationName,
                            @Nullable @Query("elementName") String[] elementName,
                            @Nullable @Query("sort") String sort,
                            @Nullable @Query("timeFrom") String timeFrom,
                            @Nullable @Query("timeTo") String timeTo);
}
