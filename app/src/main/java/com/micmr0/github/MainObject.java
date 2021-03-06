package com.micmr0.github;

import android.os.Parcel;
import android.os.Parcelable;

import com.micmr0.github.pojo.Author;
import com.micmr0.github.pojo.Commit;
import com.micmr0.github.pojo.Parent;

public class MainObject implements Parcelable{
    private String sha;
    private String node_id;
    private Commit commit;
    private String url;
    private String html_url;
    private String comments_url;
    private String message;
    private Author author;
    private Author committer;
    private Parent[] parents;

    protected MainObject(Parcel in) {
        sha = in.readString();
        node_id = in.readString();
        commit = in.readParcelable(Commit.class.getClassLoader());
        url = in.readString();
        html_url = in.readString();
        comments_url = in.readString();
        message = in.readString();
        author = in.readParcelable(Author.class.getClassLoader());
        committer = in.readParcelable(Author.class.getClassLoader());
        parents = (Parent[]) in.readArray(Parent[].class.getClassLoader());
    }

    public static final Creator<MainObject> CREATOR = new Creator<MainObject>() {
        @Override
        public MainObject createFromParcel(Parcel in) {
            return new MainObject(in);
        }

        @Override
        public MainObject[] newArray(int size) {
            return new MainObject[size];
        }
    };

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getNodeId() {
        return node_id;
    }

    public void setNodeId(String node_id) {
        this.node_id = node_id;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String html_url) {
        this.html_url = html_url;
    }

    public String getCommentsUrl() {
        return comments_url;
    }

    public void setCommentsUrl(String comments_url) {
        this.comments_url = comments_url;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getCommitter() {
        return committer;
    }

    public void setCommitter(Author committer) {
        this.committer = committer;
    }

    public Parent[] getParents() {
        return parents;
    }

    public void setParents(Parent[] parents) {
        this.parents = parents;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sha);
        dest.writeString(node_id);
        dest.writeParcelable(commit, flags);
        dest.writeString(url);
        dest.writeString(html_url);
        dest.writeString(comments_url);
        dest.writeParcelable(author, flags);
        dest.writeParcelable(committer, flags);
        dest.writeArray(parents);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
