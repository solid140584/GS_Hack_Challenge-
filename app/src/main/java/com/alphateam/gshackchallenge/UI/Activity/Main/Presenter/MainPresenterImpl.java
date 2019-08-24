package com.alphateam.gshackchallenge.UI.Activity.Main.Presenter;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;

import javax.inject.Inject;

//@PerActivity
public class MainPresenterImpl extends BasePresenterImpl implements MainPresenter {

    MainView view;

  //  @Inject
  //  public MainPresenterImpl() {
  //  }

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (MainView) view;
    }

    public interface MainView extends BaseView{

    }
}