package com.renaro.happypool.splash.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.renaro.happypool.products.view.ProductsListActivity;
import com.renaro.happypool.R;
import com.renaro.happypool.mvp.BaseActivity;
import com.renaro.happypool.splash.presenter.SplashPresenter;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class SplashActivity extends BaseActivity<SplashPresenter> {

    public static final int SPLASH_DELAY = 2000;

    @NonNull
    @Override
    protected SplashPresenter createPresenter(@NonNull final Context context) {
        return new SplashPresenter();
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        findViewById(R.id.title).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(ProductsListActivity.createIntent(getApplicationContext()));
            }
        }, SPLASH_DELAY);
    }
}
