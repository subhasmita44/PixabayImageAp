package com.example.pixabayimageapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pixabayimageapp.model.PhotoResponse;
import com.example.pixabayimageapp.repositiry.PhotRepository;

public class PhotoViewModel extends ViewModel {
    private MutableLiveData<PhotoResponse> mutableLiveData;
    private PhotRepository photoRepository;

    public void init(){
        if (mutableLiveData != null){

            return ;
        }

        photoRepository =PhotRepository.getInstance();
        mutableLiveData = photoRepository.getPhoto("17409856-b6f0db85061b020a4184ccda4", "flowers","photo");



    }

    public LiveData<PhotoResponse> getPhotoRepository() {
        return mutableLiveData;
    }

}
