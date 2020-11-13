package com.micmr0.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.micmr0.github.pojo.RootObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private RootObject repository;
    private EditText repoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repoName = findViewById(R.id.repo_name);
        final Button search = findViewById(R.id.search_button);

        final ListView listView = findViewById(R.id.history_list);

        Set<String> history = getPreferences(Context.MODE_PRIVATE).getStringSet(getString(R.string.history_sp), null);

        List<String> values = new ArrayList<>();
        if (history != null) {
            values = new ArrayList<>(history);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
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
                Set<String> history = sharedPref.getStringSet(getString(R.string.history_sp), null);

                if (history == null) {
                    history = new HashSet<>();
                }

                history.add(repoName.getText().toString());
                sharedPref.edit().putStringSet(getString(R.string.HISTORY_KEY), history).apply();
            }
        });
    }

    private void getHttpResponse(String repo) {
        String url = getString(R.string.repo_url) + repo;
        final OkHttpClient client = new OkHttpClient();
        final Request builder = new Request.Builder()
                .url(url)
                .header("Accept", getString(R.string.app_json))
                .header("Content-Type", getString(R.string.app_json))
                .method("GET", null)
                .build();

        client.newCall(builder).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(GApplication.getInstance().getRepoNames().contains(repoName.getText().toString())) {
                    HashMap<RootObject, MainObject[]> hashMap = GApplication.getInstance().getRepository();

                    for (Map.Entry<RootObject, MainObject[]> rootObjectEntry : hashMap.entrySet()) {
                        if ((rootObjectEntry.getKey()).getFullName().equals(repoName.getText().toString())) {
                            repository = rootObjectEntry.getKey();
                            break;
                        }
                    }
                    showRepository(repository);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    if(GApplication.getInstance().getRepoNames().contains(repoName)) {
                        HashMap<RootObject, MainObject[]> hashMap = GApplication.getInstance().getRepository();
                        RootObject repository = null;
                        for (Map.Entry<RootObject, MainObject[]> rootObjectEntry : hashMap.entrySet()) {
                            if (( rootObjectEntry.getKey()).getName().equals(repoName.getText().toString())) {
                                repository = rootObjectEntry.getKey();
                                break;
                            }
                        }
                        showRepository(repository);
                    }
                } else {
                    Gson gson = new Gson();
                    ResponseBody responseBody = client.newCall(builder).execute().body();
                    if (responseBody != null) {
                        repository = gson.fromJson(responseBody.string(), RootObject.class);
                        showRepository(repository);
                    }

                }
            }
        });
    }

    private void showRepository(RootObject repository) {
        Intent intent = new Intent(MainActivity.this, RepoActivity.class);
        intent.putExtra(getString(R.string.repo), repository);
        startActivity(intent);
    }
}