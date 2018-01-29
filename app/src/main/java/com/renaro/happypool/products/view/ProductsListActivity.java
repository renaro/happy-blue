package com.renaro.happypool.products.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.renaro.happypool.AppAplication;
import com.renaro.happypool.R;
import com.renaro.happypool.mvp.BaseActivity;
import com.renaro.happypool.products.model.Product;
import com.renaro.happypool.products.model.ProductBO;
import com.renaro.happypool.products.presenter.ProductsListPresenter;
import com.renaro.happypool.task.AppTaskExecutor;

import java.util.List;

import javax.inject.Inject;

public class ProductsListActivity extends BaseActivity<ProductsListPresenter> implements ProductsListView {

    @Inject
    protected ProductBO mProductBO;
    private View mLoading;
    private ProductsListAdapter mAdapter;

    public static Intent createIntent(final Context context) {
        Intent intent = new Intent(context, ProductsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @NonNull
    @Override
    protected ProductsListPresenter createPresenter(@NonNull final Context context) {
        ((AppAplication) getApplication()).getProductsComponent().inject(this);
        return new ProductsListPresenter(this, mProductBO, new AppTaskExecutor(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        mLoading = findViewById(R.id.loading);
        RecyclerView list = findViewById(R.id.list);
        mAdapter = new ProductsListAdapter();
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showResults(final List<Product> result) {
        mAdapter.setItems(result);
    }

    @Override
    public void showEmptyState() {

    }
}
