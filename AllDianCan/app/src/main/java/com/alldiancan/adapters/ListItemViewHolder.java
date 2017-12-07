package com.alldiancan.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by laliu on 12/7/2017.
 */
public class ListItemViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    public ListItemViewHolder(View itemView) {
        super(itemView);
        this.itemView =itemView;
    }

    public  View  getView() {
        return this.itemView;
    }
}
