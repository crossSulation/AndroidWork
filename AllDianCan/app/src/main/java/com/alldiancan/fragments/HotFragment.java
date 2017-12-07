package com.alldiancan.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by laliu on 12/6/2017.
 */
public class HotFragment extends Fragment {

    private String from;

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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public static HotFragment newInstance(String from) {
        HotFragment hotFragment =new HotFragment();
        hotFragment.setFrom(from);
        return hotFragment;
    }
}
