package com.fomikko.android.skillfactory_module36;

import android.util.Log;

public interface UserSomething {
    void onButtonWasClicked();
    void onDestroy();
}

class UserSomethingImpl implements UserSomething {
    private static final String TAG = "UserSomething";

    //Компоненты MVP приложения
    private UserView mView;
    private UserRepository mRepository;

    //Данные о пользователе
    private String userInfo;

    public UserSomethingImpl(UserView mView) {
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
