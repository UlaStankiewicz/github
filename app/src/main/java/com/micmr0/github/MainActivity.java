package com.micmr0.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private RootObject repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText repoName = findViewById(R.id.repo_name);
        final Button search = findViewById(R.id.search_button);

        final ListView listView = (ListView) findViewById(R.id.history_list);

        Set<String> history = getPreferences(Context.MODE_PRIVATE).getStringSet("HISTORY", null);

        List values = new ArrayList();
        if (history != null) {
            values = new ArrayList(history);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String repo = (String) listView.getAdapter().getItem(position);
                getHttpResponse(repo);
                search.callOnClick();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHttpResponse(repoName.getText().toString());

                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                Set<String> history = sharedPref.getStringSet("HISTORY", null);

                if (history == null) {
                    history = new HashSet<>();
                }

                history.add(repoName.getText().toString());
                sharedPref.edit().putStringSet("HISTORY", history).apply();

                Intent intent = new Intent(MainActivity.this, RepoActivity.class);
                intent.putExtra("REPO", repository);
                startActivity(intent);
            }
        });
    }

    private void getHttpResponse(String repo) {
        String url = "https://api.github.com/repos/" + repo;
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
                Log.d("MainActivity", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("MainActivity", "onResponse");
                if (!response.isSuccessful()) {
                    Log.d("MainActivity", "!response.isSuccessful()");
                    throw new IOException("Unexpected code");
                } else {
                    String message = response.body().string();

                    Log.d("MainActivity", "repo is: " + response.body().toString());

                    Gson gson = new Gson();
                    ResponseBody responseBody = client.newCall(builder).execute().body();

                    repository = gson.fromJson(responseBody.string(), RootObject.class);

                }
            }
        });
    }
}