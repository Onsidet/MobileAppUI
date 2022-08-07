package com.sidet.mobileappui.ui;

import com.sidet.mobileappui.R;
import com.sidet.mobileappui.app.BaseActivity;
import com.sidet.mobileappui.models.User;
import com.sidet.mobileappui.models.res.LoginRes;
import com.sidet.mobileappui.presenters.LoginPresenter;
import com.sidet.mobileappui.utils.local.UserSharedPreference;
import com.sidet.mobileappui.views.LoginView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity implements LoginView {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(username.equals("")){
                    showMessage("Username is empty");
                    return;
                }
                if (password.equals("")){
                    showMessage("Password is empty");
                    return;
                }

                loginPresenter.login(username,password);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        super.checkLogin();
    }

    private void initView(){
        etUsername  = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        loginPresenter = new LoginPresenter(this);
    }



    @Override
    public void onLoading(String message) {
        showMessage(message);
    }

    @Override
    public void onHideLoading(String message) {
        showMessage(message);
    }

    @Override
    public void onSuccess(String message) {
        showMessage(message);
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }

    @Override
    public void onServerError(String message) {
        showMessage(message);
    }

    @Override
    public void onLoginSuccess(LoginRes res) {

        User user = new User();
        user.setId(1);
        user.setUsername(res.getUsername());
        user.setPassword(res.getAccessToken());
        user.setAccessToken(res.getAccessToken());
        UserSharedPreference.setUser(LoginActivity.this,user);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        showMessage("Login Successfully!");
        finish();
    }
}