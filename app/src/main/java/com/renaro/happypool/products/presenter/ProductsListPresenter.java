package com.renaro.happypool.products.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.renaro.happypool.mvp.BasePresenter;
import com.renaro.happypool.products.model.ProductBO;
import com.renaro.happypool.products.model.Product;
import com.renaro.happypool.products.view.ProductsListView;
import com.renaro.happypool.task.AppTask;
import com.renaro.happypool.task.TaskExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

public class ProductsListPresenter extends BasePresenter {


    private final ProductBO mProductBO;
    private final TaskExecutor mTaskExecutor;
    private final ProductsListView mView;

    public ProductsListPresenter(@NonNull final ProductsListView view, @NonNull final ProductBO productBO, TaskExecutor taskExecutor) {
        mView = view;
        mTaskExecutor = taskExecutor;
        mProductBO = productBO;
    }

    @Override
    public void onResume() {
        super.onResume();
        mView.showLoading();
        mTaskExecutor.async(new FetchTrendingProductsTask());


    }

    public void searchClicked(final String text) {
        mView.showLoading();
        mTaskExecutor.async(new FetchProductsByNameTask(text));
    }

    void showProductListResult(final @Nullable List<Product> result) {
        if (result != null && !result.isEmpty()) {
            mView.showResults(result);
        } else {
            mView.showEmptyState();
        }
    }

    private class FetchTrendingProductsTask implements AppTask<List<Product>> {
        @Override
        public List<Product> execute() {
            return mProductBO.fetchTrendingProducts();
        }

        @Override
        public void onPostExecute(@Nullable final List<Product> result) {
            mView.hideLoading();
            showProductListResult(result);
        }
    }


    private class FetchProductsByNameTask implements AppTask<ArrayList<Product>> {

        private final String mText;

        public FetchProductsByNameTask(final String text) {
            mText = text;
        }

        @Override
        public ArrayList<Product> execute() {
            return mProductBO.fetchProductsByText(mText);
        }

        @Override
        public void onPostExecute(@Nullable final ArrayList<Product> result) {
            mView.hideLoading();
            showProductListResult(result);
        }
    }
}
