package com.micmr0.github;

import android.app.Application;

import com.google.gson.Gson;
import com.micmr0.github.pojo.RootObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GApplication extends Application {
    private static GApplication INSTANCE;

    private HashMap<RootObject, MainObject[]> repository;
    private ArrayList<String> repoNames;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
        repository = new HashMap<>();
        repoNames = new ArrayList<>();
    }

    public static GApplication getInstance() {
        return INSTANCE;
    }

    public HashMap<RootObject, MainObject[]> readRepositories() {
        repository = new HashMap<>();
        repoNames = new ArrayList<>();

        File userPropertiesFile = getFileStreamPath(getString(R.string.repositories));
        if (userPropertiesFile == null || !userPropertiesFile.exists()) {

        } else {
            repository = new Gson().fromJson(FileHelper.readFromFile(userPropertiesFile), HashMap.class);
            if (repository == null) {
                repository = new HashMap<>();
            }
        }

        return repository;
    }

    private void saveRepositories() {
        try {
            FileOutputStream outputStream = new FileOutputStream(getFileStreamPath(getString(R.string.repositories)));
            outputStream.write(new Gson().toJson(repository).getBytes());
            outputStream.close();
        } catch (IOException ignored) {
        }
    }

    public HashMap<RootObject, MainObject[]> getRepository() {
        return repository;
    }

    public void setRepository(HashMap<RootObject, MainObject[]> repository) {
        this.repository = repository;
    }

    public ArrayList<String> getRepoNames() {
        return repoNames;
    }

    public void setRepoNames(ArrayList<String> repoNames) {
        this.repoNames = repoNames;
    }

}
