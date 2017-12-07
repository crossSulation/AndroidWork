package com.alldiancan.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by laliu on 12/6/2017.
 */
public class HomeFragment extends Fragment {
    private  String from; // ids
    public HomeFragment() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static HomeFragment newInstance (String from) {
         HomeFragment tmp  =new HomeFragment();
         tmp.setFrom(from);
         return tmp;
    }
}
