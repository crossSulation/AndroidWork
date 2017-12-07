package com.alldiancan.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;

/**
 * Created by laliu on 12/6/2017.
 */
public class AboutMeFragment extends Fragment {

    private String from;

    public  String getFrom() {
        return this.from;
    }
    public  void setFrom(String from) {
        this.from =from;
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

    public  static  AboutMeFragment newInstance(String from) {
        AboutMeFragment tmp =new AboutMeFragment();
        tmp.setFrom(from);
        return  tmp;
    }
}
