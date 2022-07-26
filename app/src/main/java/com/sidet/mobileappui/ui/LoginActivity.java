package com.sidet.mobileappui.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.sidet.mobileappui.R;
import com.sidet.mobileappui.app.BaseActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.equals("")){
                    showMessage("Username is empty");
                    return;
                }
                if (password.equals("")){
                    showMessage("Password is empty");
                    return;
                }
            }
        });

    }

    private void initView(){
        etUsername  = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}