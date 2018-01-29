package com.renaro.happypool.dagger;

import com.renaro.happypool.products.model.AppProductDAO;
import com.renaro.happypool.products.model.ProductBO;
import com.renaro.happypool.products.model.ProductDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by renarosantos1 on 29/01/18.
 */
@Module
public class ProductsModule {


    public ProductsModule() {
    }

    @Provides
    @Singleton
    ProductBO provideProductBO(ProductDAO productDAO) {
        return new ProductBO(productDAO);
    }

    @Provides
    @Singleton
    ProductDAO provideProductDAO() {
        return new AppProductDAO();
    }

}
