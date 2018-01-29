package com.renaro.happypool.dagger;

import com.renaro.happypool.products.view.ProductsListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by renarosantos1 on 29/01/18.
 */
@Singleton
@Component(modules = {ProductsModule.class, NetModule.class})
public interface ProductsComponent {

    void inject(ProductsListActivity activity);
}
