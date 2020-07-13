package com.example.pixabayimageapp.retrofit;

import com.example.pixabayimageapp.model.PhotoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("api/")
    Call<PhotoResponse> getPhotoList(
            @Query("key") String key,
            @Query("q") String q,
            @Query("image_type") String type);
}
