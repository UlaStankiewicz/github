package com.micmr0.github;

public class Commit {
    private Author author;
    private Author committer;
    private String message;
    private Tree tree;
    private String url;
    private int comment_count;
    private Verification verification;

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
}
