package com.alldiancan.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by laliu on 12/7/2017.
 */
public class ListItemViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    private ImageView imageView;
    private TextView address;
    private TextView contactInfo;
    private  TextView dialNumber;
    private RatingBar ratingBar;
    public ListItemViewHolder(View itemView) {
        super(itemView);
        this.itemView =itemView;
    }

    public  View  getView() {
        return this.itemView;
    }
}
