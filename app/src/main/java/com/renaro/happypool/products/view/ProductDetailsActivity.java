package com.renaro.happypool.products.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renaro.happypool.R;
import com.renaro.happypool.mvp.BaseActivity;
import com.renaro.happypool.products.model.Product;
import com.renaro.happypool.products.presenter.ProductsDetailsPresenter;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

/**
 * Created by renarosantos1 on 31/01/18.
 */

public class ProductDetailsActivity extends BaseActivity<ProductsDetailsPresenter> implements ProductDetailsView {

    public static final String EXTRA_PRODUCT = "PRODUCT";
    public static final int SLIDE_INTERVAL = 10000;
    private TextView mDescription;
    private TextView mBuyButton;
    private TextView mPrice;
    private CarouselView mSlider;

    public static Intent createIntent(@NonNull final Product product, Context context) {
        Intent intent = new Intent(context, ProductDetailsActivity.class);
        intent.putExtra(EXTRA_PRODUCT, product);
        return intent;
    }


    @NonNull
    @Override
    protected ProductsDetailsPresenter createPresenter(@NonNull final Context context) {
        Product product = (Product) getIntent().getSerializableExtra(EXTRA_PRODUCT);
        if (product == null) {
            throw new IllegalArgumentException("This activity requires an extra. Use method createIntent to create this activity");
        }
        return new ProductsDetailsPresenter(product, this);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        mDescription = findViewById(R.id.description);
        mBuyButton = findViewById(R.id.buy);
        mPrice = findViewById(R.id.price);
        mSlider = findViewById(R.id.slider);
        RecyclerView list = (RecyclerView) findViewById(R.id.comments_list);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        list.setAdapter(new CommentsAdapter());
        mSlider.reSetSlideInterval(SLIDE_INTERVAL);
    }

    @Override
    public void showProductsDetails(final Product product) {
        setTitle(product.getTitle());
        mDescription.setText(product.getDescription());
        mPrice.setText(getString(R.string.euro_format, product.getPrice()));
    }

    @Override
    public void showImages(@NonNull final List<String> images) {
        mSlider.setPageCount(images.size());
        mSlider.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(final int position, final ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                Glide.with(ProductDetailsActivity.this).load(images.get(position)).into(imageView);
            }
        });
    }

    @Override
    public void showEmptyImages() {
        //TODO SHOW AN EMPTY STATE IMAGE
        mSlider.setPageCount(0);
    }
}
