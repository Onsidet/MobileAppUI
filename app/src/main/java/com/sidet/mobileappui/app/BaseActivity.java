package com.sidet.mobileappui.app;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.sidet.mobileappui.models.User;
import com.sidet.mobileappui.ui.MainActivity;
import com.sidet.mobileappui.utils.local.UserSharedPreference;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

    }

    protected void checkLogin(){
        if(null !=UserSharedPreference.getUser(this)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    protected User getUserShared(){
        return UserSharedPreference.getUser(this);
    }

}
