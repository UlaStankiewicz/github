package com.micmr0.github;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RepoActivity extends AppCompatActivity {

    private String[] myDataSet;
    private ArrayList<MainObject> commits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);

        Bundle extras = getIntent().getExtras();
        RootObject repository = (RootObject) extras.getParcelable("REPO");

        TextView repoName = findViewById(R.id.repo_name);
        repoName.setText(repository.getName());


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        getHttpResponse(repository.getFullName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter adapter = new ListAdapter(commits);
        recyclerView.setAdapter(adapter);
    }

    private void getHttpResponse(String repo) {
        String url = "https://api.github.com/repos/"+repo+"/commits";
        final OkHttpClient client = new OkHttpClient();
        final Request builder = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .method("GET", null)
                .build();

        client.newCall(builder).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("RepoActivity", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("RepoActivity", "onResponse");
                if (!response.isSuccessful()) {
                    Log.d("RepoActivity", "!response.isSuccessful()");
                    throw new IOException("Unexpected code");
                } else {
                    String message = response.body().string();

                    Log.d("RepoActivity", "repo is: " + response.body().toString());

                    Type fooType = new TypeToken<ArrayList<MainObject>>() {}.getType();
                    Gson gson = new Gson();
                    ResponseBody responseBody = client.newCall(builder).execute().body();

                    commits = gson.fromJson(responseBody.string(), fooType);

                }
            }
        });
    }

}