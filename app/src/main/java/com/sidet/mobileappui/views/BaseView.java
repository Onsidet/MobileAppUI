package com.sidet.mobileappui.views;

public interface BaseView {
    void onLoading(String message);
    void onHideLoading(String message);
    void onSuccess(String message);
    void onError(String message);
    void onServerError(String message);
}
