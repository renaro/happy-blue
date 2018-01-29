package com.renaro.happypool.products.view;

import com.renaro.happypool.products.model.Product;

import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public interface ProductsListView {
    void showLoading();

    void hideLoading();

    void showResults(List<Product> result);

    void showEmptyState();
}
