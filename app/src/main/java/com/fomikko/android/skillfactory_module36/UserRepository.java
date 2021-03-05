package com.fomikko.android.skillfactory_module36;

import android.util.Log;

public interface UserRepository {
    String loadUserInfo();
}

class UserRepositoryImpl implements UserRepository {

    private static final String TAG = "UserRepository";

    @Override
    public String loadUserInfo() {
        Log.d(TAG, "loadMessage()");
        return "Студент SkillFactory";
    }
}
