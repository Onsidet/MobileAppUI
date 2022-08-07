package com.sidet.mobileappui.utils.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.sidet.mobileappui.models.User;
import com.sidet.mobileappui.ui.MainActivity;

public class UserSharedPreference {
    public static void setUser(Context context, User user){
        SharedPreferences.Editor editor = context.getSharedPreferences("USER",Context.MODE_PRIVATE).edit();
        editor.putInt("ID",user.getId());
        editor.putString("ACCESS_TOKEN",user.getAccessToken());
        editor.putString("USERNAME",user.getUsername());
        editor.putString("PASSWORD",user.getPassword());
        editor.apply();
    }

    public static User getUser(Context context){
        SharedPreferences preferences = context.getSharedPreferences(
                "USER",Context.MODE_PRIVATE
        );
        int id = preferences.getInt("ID",0);
        String accessToken = preferences.getString("ACCESS_TOKEN","");
        String username = preferences.getString("USERNAME", "");
        String password = preferences.getString("PASSWORD", "");
        if (!username.equals("")){
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setAccessToken(accessToken);
            return user;
        }

        return null;
    }
    public static String getToken(Context context){
        SharedPreferences preferences = context.getSharedPreferences(
                "USER",Context.MODE_PRIVATE
        );
        String accessToken = preferences.getString("ACCESS_TOKEN","");
        return "Bearer "+ accessToken;
    }

    public static void removeUser(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("USER",Context.MODE_PRIVATE).edit();
        editor.remove("ID");
        editor.remove("USERNAME");
        editor.remove("PASSWORD");
        editor.remove("ACCESS_TOKEN");
        editor.apply();
    }
}
