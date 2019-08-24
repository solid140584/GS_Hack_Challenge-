package com.alphateam.gshackchallenge.UI.Activity.Home.Presenter;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.DI.Component.PerActivity;

import javax.inject.Inject;

@PerActivity
public class MiMomentoPresenterImpl extends BasePresenterImpl implements MiMomentoPresenter {

    MiMomentoView view;

    @Inject
    public MiMomentoPresenterImpl() {

    }

    @Override
    public void register(BaseView view) {
        super.register(view);

        this.view = (MiMomentoView) view;

    }

    public interface MiMomentoView extends BaseView{


    }
}