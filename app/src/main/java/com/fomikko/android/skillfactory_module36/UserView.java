package com.fomikko.android.skillfactory_module36;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public interface UserView {
    void showUserInfo(String userInfo);
}

class UserActivity extends AppCompatActivity implements UserView {

    private static final String TAG = "UserActivity";

    private UserPresenter mPresenter;

    private Button mButton;

    private TextView tvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Создаём Presenter и в аргументе передаём ему this - эта Activity расширяет интерфейс MainContract.View
        mPresenter = new UserPresenterImpl(this);

        tvUserInfo = (TextView) findViewById(R.id.text_view);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtonWasClicked();
            }
        });
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void showUserInfo(String message) {
        tvUserInfo.setText(message);
        Log.d(TAG, "showUserInfo()");
    }

    //Вызываем у Presenter метод onDestroy, чтобы избежать утечек контекста и прочих неприятностей.
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
