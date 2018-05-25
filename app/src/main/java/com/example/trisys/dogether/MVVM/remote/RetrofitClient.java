package com.example.trisys.dogether.MVVM.remote;

import com.example.trisys.dogether.MVVM.Utils.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trisys on 23/4/18.
 */

public class RetrofitClient {


    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static APIService getAPIService(){
        return getRetrofitInstance().create(APIService.class);
    }
}
