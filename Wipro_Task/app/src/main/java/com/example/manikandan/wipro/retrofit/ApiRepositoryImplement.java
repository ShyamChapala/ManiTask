package com.example.manikandan.wipro.retrofit;

import com.example.manikandan.wipro.model.ApiResponse;

import java.util.List;

import io.reactivex.Single;

public class ApiRepositoryImplement implements ApiRepository {

    private APIService mApiService;

    public ApiRepositoryImplement(){
        mApiService =APIService.Creator.getApiService();

    }
    @Override
    public Single<ApiResponse> getResponse() {
        return mApiService.getResponse();
    }
}
