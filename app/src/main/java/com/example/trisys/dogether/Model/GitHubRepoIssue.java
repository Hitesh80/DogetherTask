package com.example.trisys.dogether.Model;

/**
 * Created by Hitesh on 3/4/18.
 */

public class GitHubRepoIssue {
    private String title;
    private int number;
    private String state;
    private int id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String created_at;
    public String comments_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}