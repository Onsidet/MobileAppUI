package com.sidet.mobileappui.views;

import com.sidet.mobileappui.models.res.LoginRes;

public interface LoginView extends BaseView{
    void onLoginSuccess(LoginRes res);
}
