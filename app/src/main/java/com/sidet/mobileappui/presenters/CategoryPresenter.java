package com.sidet.mobileappui.presenters;

import com.sidet.mobileappui.models.res.CategoryRes;
import com.sidet.mobileappui.utils.Utils;
import com.sidet.mobileappui.views.CategoryView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryPresenter {
    private CategoryView view;

    public CategoryPresenter(CategoryView view) {
        this.view = view;
    }

    public void getAllCategory(String token){
        view.onLoading("");
        Call<CategoryRes> categoryResCall = Utils.getClientsAPIs().getAllCategory(token);
        categoryResCall.enqueue(new Callback<CategoryRes>() {
            @Override
            public void onResponse(Call<CategoryRes> call, Response<CategoryRes> response) {
                view.onHideLoading("");
                if (response.isSuccessful() && null != response.body()){
                    view.onSuccess("");
                    view.setData(response.body().getCategoryList());
                }
            }

            @Override
            public void onFailure(Call<CategoryRes> call, Throwable t) {
                view.onHideLoading("");
                view.onServerError("Connection timeout");
            }
        });
    }
}
