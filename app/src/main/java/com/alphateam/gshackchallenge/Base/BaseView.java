package com.alphateam.gshackchallenge.Base;

import android.app.Activity;

public interface BaseView {

    void initView();
    void setListeners();
    void setPresenter();
    void showLoader();
    void hideLoader();
    Activity getActivityInstance();

}