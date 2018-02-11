package com.example.manikandan.wipro.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

import com.example.manikandan.wipro.model.ApiResponse;
import com.example.manikandan.wipro.retrofit.ApiRepositoryImplement;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class MainActivityViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable;
    private MediatorLiveData<ApiResponse> liveDataResponse;
    private MediatorLiveData<Boolean> loading;
    private ApiRepositoryImplement apiRepositoryImplement;

    public MainActivityViewModel(){
        compositeDisposable = new CompositeDisposable();
        apiRepositoryImplement = new ApiRepositoryImplement();
        liveDataResponse = new MediatorLiveData<>();
        loading = new MediatorLiveData<>();
    }

    public void callApi(){
        loading.setValue(true);
        Single<ApiResponse> response = apiRepositoryImplement.getResponse();
        Disposable disposable = response.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ApiResponse>(){

                    @Override
                    public void onSuccess(ApiResponse apiResponse) {
                        loading.setValue(false);
                        if(apiResponse != null)
                        liveDataResponse.setValue(apiResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loading.setValue(false);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public LiveData<ApiResponse> getReactiveResponse() {
        if (liveDataResponse == null) {
            liveDataResponse = new MediatorLiveData<>();
        }
        return liveDataResponse;
    }

    public LiveData<Boolean> getLoading() {
        if (loading == null) {
            loading = new MediatorLiveData<>();
        }
        return loading;
    }
}
