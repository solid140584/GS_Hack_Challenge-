package com.alphateam.gshackchallenge.UI.Activity.Main.Presenter;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenter;

import javax.inject.Inject;

@PerActivity
public class MainPresenterImpl extends BasePresenterImpl implements MainPresenter {

    MainView view;

    @Inject
    public MainPresenterImpl() {
    }

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (MainView) view;
    }

    public interface MainView extends BaseView{

    }
}
