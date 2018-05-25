package com.example.trisys.dogether.MVVM.DB;

/**
 * Created by trisys on 21/4/18.
 */

public class LoginUser {

    private String userName;
    private String password;
    public String userNameHint;
    public String passwordHint;

    public LoginUser(String userNameHint, String passwordHint) {
        this.userNameHint = userNameHint;
        this.passwordHint = passwordHint;
    }


}
