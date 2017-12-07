package com.alldiancan.utils;
import android.support.v4.app.Fragment;
import com.alldiancan.fragments.*;

/**
 * Created by laliu on 12/6/2017.
 */
public class DataGenerator {

    public static  String[] btnTitles =new String[] {"首页","购物车","发现","关于我"};
    public static Fragment[] getFragments(String from){
        Fragment fragments[] = new Fragment[4];
        fragments[0] = HomeFragment.newInstance(from);
        fragments[1] = HotFragment.newInstance(from);
        fragments[2] = ShoppingCarFragment.newInstance(from);
        fragments[3] = AboutMeFragment.newInstance(from);
        return fragments;
    }


}
