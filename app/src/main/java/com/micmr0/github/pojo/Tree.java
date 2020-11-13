package com.micmr0.github.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Tree implements Parcelable {
    private String sha;
    private String url;

    protected Tree(Parcel in) {
        sha = in.readString();
        url = in.readString();
    }

    public static final Creator<Tree> CREATOR = new Creator<Tree>() {
        @Override
        public Tree createFromParcel(Parcel in) {
            return new Tree(in);
        }

        @Override
        public Tree[] newArray(int size) {
            return new Tree[size];
        }
    };

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sha);
        dest.writeString(url);
    }
}
