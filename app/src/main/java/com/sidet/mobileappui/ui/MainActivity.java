package com.sidet.mobileappui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sidet.mobileappui.R;
import com.sidet.mobileappui.app.BaseActivity;
import com.sidet.mobileappui.utils.local.UserSharedPreference;


import java.util.Locale;

public class MainActivity extends BaseActivity {
    private TextView tvUsername;
    private Button btnSingOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUsername = findViewById(R.id.tvUsername);
        btnSingOut = findViewById(R.id.btnSignOut);
        tvUsername.setText(getUserShared().getUsername().toUpperCase());

        btnSingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                UserSharedPreference.removeUser(MainActivity.this);
            }
        });
    }

   
}