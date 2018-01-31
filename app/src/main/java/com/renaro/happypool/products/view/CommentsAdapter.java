package com.renaro.happypool.products.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renaro.happypool.R;

import java.util.ArrayList;

/**
 * Created by renarosantos1 on 31/01/18.
 */

class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private ArrayList<Comments> mComments;

    public CommentsAdapter() {
        mComments = new ArrayList<>();
        mComments.add(new Comments("Anna Rock", "This is the best item I bought this year. I am so happy I saw it","https://www.gravatar.com/wavatar/1?s=200"));
        mComments.add(new Comments("John Nesh", "Totally recommend this product, I have it for one year already","https://www.gravatar.com/wavatar/2?s=200"));
        mComments.add(new Comments("Jeff Capp", "It is something I am willing to buy again very soon.","https://www.gravatar.com/wavatar/3?s=200"));

    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bind(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mComments;
        private TextView mName;
        private ImageView mImage;

        public ViewHolder(final View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mComments = itemView.findViewById(R.id.comments);
            mImage = itemView.findViewById(R.id.imageCommenter);

        }

        public void bind(final Comments comments) {
            mName.setText(comments.name);
            mComments.setText(comments.comment);
            Glide.with(mImage.getContext()).load(comments.url).into(mImage);
        }
    }

    class Comments {
        private String name;
        private String comment;
        private String url;

        public Comments(final String name, final String comment, final String url) {
            this.name = name;
            this.comment = comment;
            this.url = url;
        }
    }
}
