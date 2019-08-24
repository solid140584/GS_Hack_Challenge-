package com.alphateam.gshackchallenge.Base;

import android.app.Activity;

public interface BaseView {

    void initView();
    void implementOnClickListener();
    void setPresenter();
    void showLoader();
    void hideLoader();
    Activity getActivityInstance();

}