package com.micmr0.github;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.micmr0.github.pojo.RootObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RepoActivity extends AppCompatActivity {
    private MainObject[] commits;
    private RecyclerView recyclerView;
    private ArrayList<MainObject> commitsToSend;
    private RootObject repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);

        Bundle extras = getIntent().getExtras();
        repository = null;
        if (extras != null) {
            repository = extras.getParcelable(getString(R.string.repo));
        }

        TextView repoName = findViewById(R.id.repo_name);
        Button sendButton = findViewById(R.id.send);

        if (repository != null) {
            repoName.setText(repository.getName());
        }

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        if (repository != null) {
            getHttpResponse(repository.getFullName());
        }

        commitsToSend = new ArrayList<>();
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (commitsToSend.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getString(R.string.suffix_info));
                    for (MainObject mo : commitsToSend) {
                        sb.append(mo.getMessage()).append(',').append(mo.getSha()).append(",").append(mo.getCommit().getAuthor().getName()).append(";\n");
                    }

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                } else {
                    Toast.makeText(RepoActivity.this, getString(R.string.send_info), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void getHttpResponse(String repo) {
        String url = getString(R.string.repo_url) + repo + "/commits";
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
                Map<RootObject, MainObject[]> hashMap = GApplication.getInstance().getRepository();
                for (Map.Entry<RootObject, MainObject[]> rootObjectEntry : hashMap.entrySet()) {
                    Map.Entry pair = rootObjectEntry;
                    if (((RootObject) pair.getKey()).getFullName().equals(repository.getFullName())) {
                        commits = (MainObject[]) pair.getValue();
                        break;
                    }
                }

                initializeAdapter();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {

                    Map<RootObject, MainObject[]> hashMap = GApplication.getInstance().getRepository();
                    for (Map.Entry<RootObject, MainObject[]> rootObjectEntry : hashMap.entrySet()) {
                        Map.Entry pair = rootObjectEntry;
                        if (((RootObject) pair.getKey()).getName().equals(repository.getName())) {
                            commits = (MainObject[]) pair.getValue();
                            break;
                        }
                    }
                } else {
                    Type fooType = new TypeToken<MainObject[]>() {
                    }.getType();
                    Gson gson = new Gson();
                    ResponseBody responseBody = client.newCall(builder).execute().body();

                    commits = gson.fromJson(responseBody.string(), fooType);

                    GApplication.getInstance().getRepository().put(repository, commits);
                    GApplication.getInstance().getRepoNames().add(repository.getFullName());
                }

                initializeAdapter();
            }
        });
    }

    private void initializeAdapter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayoutManager layoutManager = new LinearLayoutManager(RepoActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                ListAdapter adapter = new ListAdapter(commits, new OnSendButtonClicked() {
                    @Override
                    public void onButtonClick(boolean add, MainObject mainObject) {
                        if (add) {
                            commitsToSend.add(mainObject);
                        }
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        });
    }
}