package com.fomikko.android.skillfactory_module36;

import android.util.Log;

public interface UserPresenter {
    void onButtonWasClicked();
    void onDestroy();
}

class UserPresenterImpl implements UserPresenter {
    private static final String TAG = "UserPresenter";

    //Компоненты MVP приложения
    private UserView mView;
    private UserRepository mRepository;

    //Данные о пользователе
    private String userInfo;

    public UserPresenterImpl(UserView mView) {
        this.mView = mView;
        this.mRepository = new UserRepositoryImpl();
        Log.d(TAG, "Constructor");
    }

    //View сообщает, что кнопка была нажата
    @Override
    public void onButtonWasClicked() {
        userInfo = mRepository.loadUserInfo();
        mView.showUserInfo(userInfo);
        Log.d(TAG, "onButtonWasClicked()");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
    }
}
