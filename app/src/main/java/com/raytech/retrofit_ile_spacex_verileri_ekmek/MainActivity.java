package com.raytech.retrofit_ile_spacex_verileri_ekmek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PostsAdapter adapter;
    List<Repo> postsList = new ArrayList<Repo>();
    RestInterface restInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tanımlamalarım
        recyclerView = findViewById(R.id.reyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostsAdapter(postsList);
        recyclerView.setAdapter(adapter);


        restInterface = ApiClient.getClient().create(RestInterface.class);

        Call<List<Repo>> call = restInterface.getRepo();

        call.enqueue(new Callback<List<Repo>>() {

            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repoList = new ArrayList<>();
                repoList = response.body();

                if (response.isSuccessful() && response.body() != null) {
                   postsList.addAll(repoList);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
            }
        });

    }
}