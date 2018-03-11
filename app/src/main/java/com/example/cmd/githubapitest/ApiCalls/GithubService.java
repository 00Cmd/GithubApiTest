package com.example.cmd.githubapitest.ApiCalls;

import com.example.cmd.githubapitest.POJO.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by cmd on 10.03.18.
 */

public interface GithubService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
