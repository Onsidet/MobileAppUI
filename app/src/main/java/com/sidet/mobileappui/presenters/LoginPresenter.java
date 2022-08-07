package com.sidet.mobileappui.presenters;

import com.sidet.mobileappui.models.req.LoginReq;
import com.sidet.mobileappui.models.res.LoginRes;
import com.sidet.mobileappui.utils.Utils;
import com.sidet.mobileappui.views.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private LoginView view;

    public LoginPresenter(LoginView view){
        this.view = view;
    }

    public void login(String username, String password){
        view.onLoading("Loading");
        LoginReq req = new LoginReq();
        req.setPhone(username);
        req.setPassword(password);
        Call<LoginRes> loginResCall = Utils.getClientsAPIs().login(req);
        loginResCall.enqueue(new Callback<LoginRes>() {
            @Override
            public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {
                view.onHideLoading("Hiding...");
                if (response.code() == 401){
                    view.onError("Your username and password is incorrect");
                }
                if(response.isSuccessful() && null != response.body()){
                    view.onLoginSuccess(response.body());
                    view.onSuccess("Login Success");
                }
            }

            @Override
            public void onFailure(Call<LoginRes> call, Throwable t) {
                view.onHideLoading("Hiding...");
                view.onServerError("Your Connection timeout!");
            }
        });
    }
}
