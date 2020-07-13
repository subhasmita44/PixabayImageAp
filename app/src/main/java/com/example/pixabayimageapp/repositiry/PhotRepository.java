package com.example.pixabayimageapp.repositiry;

import androidx.lifecycle.MutableLiveData;
import com.example.pixabayimageapp.model.PhotoResponse;
import com.example.pixabayimageapp.retrofit.Api;
import com.example.pixabayimageapp.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotRepository {
    private static PhotRepository newsRepository;

    public static PhotRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new PhotRepository();
        }
        return newsRepository;
    }

    private Api photoApi;

    public PhotRepository(){
        photoApi = RetrofitService.cteateService(Api.class);
    }

    public MutableLiveData<PhotoResponse> getPhoto(String key, String q,String image_type){
        final MutableLiveData<PhotoResponse> photoData = new MutableLiveData<>();
        photoApi.getPhotoList(key, q,image_type).enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {

                if (response.isSuccessful()){

                    photoData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                photoData.setValue(null);
            }
        });
        return photoData;
    }
}
