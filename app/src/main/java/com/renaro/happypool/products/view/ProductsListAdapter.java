package com.renaro.happypool.products.view;

import android.graphics.Paint;
import android.support.annotation.NonNull;
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
    private OnItemClicked mListener;

    public void setListener(final OnItemClicked listener) {
        mListener = listener;
    }

    public void setItems(final List<Product> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
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

    public interface OnItemClicked {
        void onItemClicked(@NonNull final Product product);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;
        private TextView mPrice;
        private TextView mOldPrice;
        private ImageView mImage;
        private Product mProduct;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new OnItemClick());
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.description);
            mPrice = itemView.findViewById(R.id.price);
            mOldPrice = itemView.findViewById(R.id.oldPrice);
            mImage = itemView.findViewById(R.id.productImage);
            mOldPrice.setTextColor(mOldPrice.getContext().getResources().getColor(R.color.niceRed));
            mOldPrice.setPaintFlags(mOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        private void bind(final Product product) {
            mProduct = product;
            mTitle.setText(product.getTitle());
            mDescription.setText(product.getDescription());
            mPrice.setText(String.format(mPrice.getContext().getString(R.string.euro_format), product.getPrice()));
            mOldPrice.setText(String.format(mPrice.getContext().getString(R.string.euro_format), product.getOldPrice()));
            if(product.getOldPrice() ==  0f){
                mOldPrice.setVisibility(View.INVISIBLE);
            } else {
                mOldPrice.setVisibility(View.VISIBLE);
            }
            Glide.with(mImage.getContext()).load(product.getImages().get(0)).centerCrop().dontAnimate().into(mImage);
        }

        private class OnItemClick implements View.OnClickListener {
            @Override
            public void onClick(final View v) {
                if (mListener != null) {
                    mListener.onItemClicked(mProduct);
                }
            }
        }
    }

}
