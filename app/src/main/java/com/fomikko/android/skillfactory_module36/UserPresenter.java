package com.fomikko.android.skillfactory_module36;

import android.util.Log;

public class UserPresenter implements IUserPresenter {
    private static final String TAG = "UserPresenter";

    //Компоненты MVP приложения
    private UserView mView;
    private IUserRepository mRepository;

    //Данные о пользователе
    private String userInfo;

    public UserPresenter(UserView mView) {
        this.mView = mView;
        this.mRepository = new UserRepository();
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
