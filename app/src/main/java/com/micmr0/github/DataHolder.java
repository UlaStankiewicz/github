package com.micmr0.github;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.micmr0.github.pojo.RootObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder implements Parcelable {
    private HashMap<RootObject, MainObject[]> repository;
    private ArrayList<String> repoNames;

    protected DataHolder(Parcel in) {
    }

    public static final Creator<DataHolder> CREATOR = new Creator<DataHolder>() {
        @Override
        public DataHolder createFromParcel(Parcel in) {
            return new DataHolder(in);
        }

        @Override
        public DataHolder[] newArray(int size) {
            return new DataHolder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
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
}
