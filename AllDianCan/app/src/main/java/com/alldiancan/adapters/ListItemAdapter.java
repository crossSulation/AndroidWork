package com.alldiancan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alldiancan.R;

/**
 * Created by laliu on 12/7/2017.
 */
public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {
    private Context context;
    public ListItemAdapter(Context context) {
        super();
        this.context =context;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder listItemViewHolder, int i) {

    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public boolean onFailedToRecycleView(ListItemViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewAttachedToWindow(ListItemViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(ListItemViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewRecycled(ListItemViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
    }
}
