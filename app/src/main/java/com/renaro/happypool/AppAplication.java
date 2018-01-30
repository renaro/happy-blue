package com.renaro.happypool;

import android.app.Application;
import android.os.Build;

import com.renaro.happypool.dagger.DaggerProductsComponent;
import com.renaro.happypool.dagger.NetModule;
import com.renaro.happypool.dagger.ProductsComponent;
import com.renaro.happypool.dagger.ProductsModule;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class AppAplication extends Application {

    ProductsComponent mProductsComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mProductsComponent = DaggerProductsComponent.builder().netModule(new NetModule(BuildConfig.FIREBASE))
                .productsModule(new ProductsModule()).build();

    }

    public ProductsComponent getProductsComponent() {
        return mProductsComponent;
    }
}
