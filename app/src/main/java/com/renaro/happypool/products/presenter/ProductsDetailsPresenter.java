package com.renaro.happypool.products.presenter;

import android.support.annotation.NonNull;

import com.renaro.happypool.mvp.BasePresenter;
import com.renaro.happypool.products.model.Product;
import com.renaro.happypool.products.view.ProductDetailsView;

/**
 * Created by renarosantos1 on 31/01/18.
 */

public class ProductsDetailsPresenter extends BasePresenter{

    private final Product mProduct;
    private final ProductDetailsView mView;

    public ProductsDetailsPresenter(@NonNull final Product product, @NonNull final ProductDetailsView
                                    view) {
        mView = view;
        mProduct = product;
    }

    @Override
    public void onResume() {
        super.onResume();
        mView.showProductsDetails(mProduct);
        showImages();
    }

    private void showImages() {
        if (mProduct != null && mProduct.getImages().size() >0) {
            mView.showImages(mProduct.getImages());
        } else {
            mView.showEmptyImages();
        }
    }
}
