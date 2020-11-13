package com.micmr0.github.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Commit implements Parcelable {
    private Author author;
    private Author committer;
    private String message;
    private Tree tree;
    private String url;
    private int comment_count;
    private Verification verification;

    protected Commit(Parcel in) {
        author = in.readParcelable(Author.class.getClassLoader());
        committer = in.readParcelable(Author.class.getClassLoader());
        message = in.readString();
        tree = in.readParcelable(Tree.class.getClassLoader());
        url = in.readString();
        comment_count = in.readInt();
        verification = in.readParcelable(Verification.class.getClassLoader());
    }

    public static final Creator<Commit> CREATOR = new Creator<Commit>() {
        @Override
        public Commit createFromParcel(Parcel in) {
            return new Commit(in);
        }

        @Override
        public Commit[] newArray(int size) {
            return new Commit[size];
        }
    };

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCommentCount() {
        return comment_count;
    }

    public void setCommentCount(int comment_count) {
        this.comment_count = comment_count;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(author, flags);
        dest.writeParcelable(committer, flags);
        dest.writeString(message);
        dest.writeParcelable(tree, flags);
        dest.writeString(url);
        dest.writeInt(comment_count);
        dest.writeParcelable(verification, flags);
    }
}
