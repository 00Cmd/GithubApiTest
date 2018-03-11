package com.example.cmd.githubapitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.cmd.githubapitest.ApiCalls.GithubService;
import com.example.cmd.githubapitest.Data.RetrofitClient;
import com.example.cmd.githubapitest.POJO.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String END_POINT = "https://api.github.com/";


    private Retrofit mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClient = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = mClient.create(GithubService.class);
        Call<List<Repo>> callback = service.listRepos("00Cmd");
        callback.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    List<Repo> mRepos = response.body();
                    for (int i = 0; i < mRepos.size() ; i++) {
                        Toast.makeText(MainActivity.this," Repository name : " + mRepos.get(i).getName()
                                + ", Repository id : " + mRepos.get(i).getId(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
