package com.example.trisys.dogether.MVVM.ViewModel;


import android.databinding.ObservableField;

import com.example.trisys.dogether.MVVM.DB.LoginUser;

/**
 * Created by trisys on 21/4/18.
 */

public class LoginUserModel {
    private ObservableField<String> userName;
    private ObservableField<String> password;
    private String userNameHint;
    private String passwordHint;

    public LoginUserModel(LoginUser loginUser){
        this.userNameHint=loginUser.userNameHint;
        this.passwordHint=loginUser.passwordHint;
    }
   // @Bindable
    public ObservableField<String> getUserName() {
        return userName;
    }

    public void setUserName(ObservableField<String> userName) {
        this.userName = userName;
        //notifyPropertyChanged(R.id.user_id_et);
    }
  //  @Bindable
    public ObservableField<String> getPassword() {
        return password;
    }

    public void setPassword(ObservableField<String> password) {
        this.password = password;
       // notifyPropertyChanged(R.id.password_et);
    }

    public String getUserNameHint() {
        return userNameHint;
    }

    public void setUserNameHint(String userNameHint) {
        this.userNameHint = userNameHint;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }


}
