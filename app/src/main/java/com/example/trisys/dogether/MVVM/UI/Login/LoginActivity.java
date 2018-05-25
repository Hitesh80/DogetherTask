package com.example.trisys.dogether.MVVM.UI.Login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

import com.example.trisys.dogether.MVVM.Commands.LoginUserEvent;
import com.example.trisys.dogether.MVVM.DB.LoginUser;
import com.example.trisys.dogether.MVVM.ViewModel.LoginUserModel;
import com.example.trisys.dogether.R;
import com.example.trisys.dogether.databinding.ActivityLoginBinding;

import rx.Observable;

public class LoginActivity extends AppCompatActivity {
  ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
//        setContentView(R.layout.activity_login);

        activityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        LoginUserModel loginUserModel=new LoginUserModel(new LoginUser("Type ID","PIN"));
        activityLoginBinding.setLogin(loginUserModel);

        activityLoginBinding.setLoginUserEvent(new LoginUserEvent() {
            @Override
            public void onClickLogin() {

                Toast.makeText(getApplicationContext(),activityLoginBinding.getLogin().getUserName().toString(),Toast.LENGTH_SHORT).show();

              //  Observable<String> observable=activityLoginBinding.getLogin().getUserName();
            }
        });
    }
}
