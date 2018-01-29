package com.renaro.happypool.products.view;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renaro.happypool.R;
import com.renaro.happypool.products.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos1 on 29/01/18.
 */

class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {

    private ArrayList<Product> mItems = new ArrayList<>();

    public void setItems(final List<Product> items) {
        mItems.clear();
        mItems.addAll(items);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Product product = mItems.get(position);
        if (product != null) {
            holder.bind(product);
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;
        private TextView mPrice;
        private TextView mOldPrice;
        private ImageView mImage;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.description);
            mPrice = itemView.findViewById(R.id.price);
            mOldPrice = itemView.findViewById(R.id.oldPrice);
            mImage = itemView.findViewById(R.id.productImage);
            mOldPrice.setTextColor(mOldPrice.getContext().getResources().getColor(R.color.niceRed));
            mOldPrice.setPaintFlags(mOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        private void bind(final Product product) {
            mTitle.setText(product.getTitle());
            mDescription.setText(product.getDescription());
            mPrice.setText(String.format("%.2f EUR",product.getPrice()));
            mOldPrice.setText(String.format("%.2f EUR",product.getOldPrice()));
            Glide.with(mImage.getContext()).load(product.getImageUrl()).centerCrop().dontAnimate().into(mImage);
        }
    }
}
