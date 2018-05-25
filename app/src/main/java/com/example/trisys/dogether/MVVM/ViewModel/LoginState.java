package com.example.trisys.dogether.MVVM.ViewModel;

import android.database.Observable;

/**
 * Created by trisys on 18/4/18.
 */

public class LoginState {

   public  Observable<String> email;
    public Observable<String> phone;

//    LoginState()
    //}
    public  Observable<String> emailValid;
    public Observable<String> phoneValid;
    public Observable<Boolean> loginEnabled;


}
