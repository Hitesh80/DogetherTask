package com.example.trisys.dogether.Model;

/**
 * Created by trisys on 5/4/18.
 */

public class User {
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    private String login;
    private String avatar_url;
}
