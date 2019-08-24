package com.alphateam.gshackchallenge.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface BasePresenter {

    BaseView getView();

    void setArguments(Intent intent);

    void setArguments(Bundle bundle);

    void onCreate(@Nullable final Bundle savedInstanceState);

    void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onViewCreated(View view, @Nullable Bundle savedInstanceState);

    void register(BaseView view);

    void unregister(BaseView view);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSaveInstanceState(@NonNull final Bundle outState);

    void onDestroy();

    void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data);

    void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults);

    void onShowLoader();

    void onHideLoader();

}