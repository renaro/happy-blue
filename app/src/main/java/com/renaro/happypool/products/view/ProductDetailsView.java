package com.renaro.happypool.products.view;

import android.support.annotation.NonNull;

import com.renaro.happypool.products.model.Product;

import java.util.List;

/**
 * Created by renarosantos1 on 31/01/18.
 */

public interface ProductDetailsView {
    void showProductsDetails(Product product);

    void showImages(@NonNull List<String> images);

    void showEmptyImages();
}
