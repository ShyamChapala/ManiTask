package com.example.manikandan.wipro.retrofit;

import com.example.manikandan.wipro.model.ApiResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface ApiRepository {

    Single<ApiResponse> getResponse();
}
