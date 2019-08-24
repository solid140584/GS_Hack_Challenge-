package com.alphateam.gshackchallenge.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BasePresenterImpl implements BasePresenter {

    BaseView view;


    @Override
    public void setArguments(Intent intent) {

    }

    @Override
    public void setArguments(Bundle bundle) {

    }

    @Override
    public BaseView getView() {
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void register(BaseView view) {
        this.view = view;
        this.view.initView();
        this.view.implementOnClickListener();
    }

    @Override
    public void unregister(BaseView view) {
        if (this.view == view) this.view = null;
    }


    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public void onShowLoader() {
       view.showLoader();
    }

    @Override
    public void onHideLoader() {
       view.hideLoader();
    }
}
