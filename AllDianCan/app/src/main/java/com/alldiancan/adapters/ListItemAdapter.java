package com.alldiancan.adapters;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alldiancan.R;
import com.alldiancan.models.RestoBasicInfo;

import java.util.List;

/**
 * Created by laliu on 12/7/2017.
 */
public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {
    private Context context;
    private List<RestoBasicInfo> restoBasicInfos;
    public ListItemAdapter(Context context,List<RestoBasicInfo> restoBasicInfos) {
        super();
        this.context =context;
        this.restoBasicInfos =restoBasicInfos;
    }

    @Override
    public int getItemCount() {
        return restoBasicInfos.size();
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
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
        View view = LayoutInflater.from(this.context).inflate(R.layout.list_item,viewGroup,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_img);
        imageView.setImageURI(restoBasicInfos.get(i).getImginfo());
        TextView address =(TextView) view.findViewById(R.id.address);
        address.setText(restoBasicInfos.get(i).getRestoAddress());
        TextView contactor =(TextView)view.findViewById(R.id.contact);
        contactor.setText(restoBasicInfos.get(i).getContact());
        TextView dialnumber =(TextView)view.findViewById(R.id.dialnumber);
        dialnumber.setText(restoBasicInfos.get(i).getDialnumber());
        RatingBar ratingBar =(RatingBar)view.findViewById(R.id.ratingBar_prefer);
        ratingBar.setMax(5);
        ratingBar.setNumStars(restoBasicInfos.get(i).getRanks());
        ListItemViewHolder listItemViewHolder = new ListItemViewHolder(view);
        return  listItemViewHolder;
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
