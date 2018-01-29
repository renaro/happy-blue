package com.renaro.happypool.products.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.renaro.happypool.mvp.BasePresenter;
import com.renaro.happypool.products.model.ProductBO;
import com.renaro.happypool.products.model.Product;
import com.renaro.happypool.products.view.ProductsListView;
import com.renaro.happypool.task.AppTask;
import com.renaro.happypool.task.TaskExecutor;

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
        mTaskExecutor.async(new FetchTrendingProductsTask());
        mView.showLoading();


    }

    private class FetchTrendingProductsTask implements AppTask<List<Product>> {
        @Override
        public List<Product> execute() {
            return mProductBO.fetchTrendingProducts();
        }

        @Override
        public void onPostExecute(@Nullable final List<Product> result) {
            mView.hideLoading();
            if (result != null && !result.isEmpty()) {
                mView.showResults(result);
            } else {
                mView.showEmptyState();
            }

        }
    }
}
