package com.example.cmd.githubapitest.Data;

import com.example.cmd.githubapitest.ApiCalls.GithubService;
import com.example.cmd.githubapitest.POJO.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cmd on 11.03.18.
 */

public class RetrofitClient {

    private static Retrofit mClient;

    public static Retrofit getClient() {
        if (mClient == null) {


        }
        return mClient;
    }
}
