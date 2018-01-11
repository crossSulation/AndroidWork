package com.alldiancan.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alldiancan.R;
import com.alldiancan.adapters.ListItemAdapter;
import com.alldiancan.models.Restaurant;
import com.alldiancan.utils.HttpCallBackEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by laliu on 12/6/2017.
 */
public class HomeFragment extends Fragment {

    ListItemAdapter listItemAdapter;
    private final static String GET_ALL_RESTAURANTS_URL ="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.home_fragment,container,false);
        setAddapter(view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static HomeFragment newInstance() {
        HomeFragment homeFragment =new HomeFragment();
        return  homeFragment;
    }

    private void setAddapter(View view) {
        HashMap<String,String> headers = new HashMap<>();
        headers.put("x-token","xxxxxeettteeettt");
        headers.put("sm_user","");
        List<Restaurant> restaurants;
        HttpCallBackEnd<List<Restaurant>> httpCallBackEnd =new HttpCallBackEnd<>();
        try {
            restaurants= httpCallBackEnd.getRequest(GET_ALL_RESTAURANTS_URL,headers,null);
            listItemAdapter = new ListItemAdapter(this.getActivity(),restaurants);
            RecyclerView recyclerView =(RecyclerView)view.findViewById(R.id.recommend_list);
            recyclerView.setAdapter(listItemAdapter);
        }catch (Exception e) {
            Log.e("ERR",e.getMessage());
        }
    }
}
