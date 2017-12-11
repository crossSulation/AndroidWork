package com.alldiancan;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alldiancan.fragments.AboutMeFragment;
import com.alldiancan.fragments.HomeFragment;
import com.alldiancan.fragments.HotFragment;
import com.alldiancan.fragments.ShoppingCarFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private List<Fragment> mFragments;
    private Resources resources ;
    private final String  HOME_FRAGMENT_TAG ="home";
    private final String  SHOPPING_FRAGMENT_TAG ="shopping";
    private final String  DISCOVERY_FRAGMENT_TAG ="discovery";
    private final String  ABOUTME_FRAGMENT_TAG ="aboutme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        ActionBar actionBar =getActionBar();
//        actionBar.hide();
        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout)findViewById(R.id.bottom_layout);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#0c3fce"));
        resources =this.getResources();
         mFragments =new ArrayList<Fragment>();
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(ShoppingCarFragment.newInstance());
        mFragments.add(HotFragment.newInstance());
        mFragments.add(AboutMeFragment.newInstance());
        final FragmentManager fragmentManager = getFragmentManager();
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    // first page
                    case 0:
                        hidenFragment(fragmentManager,SHOPPING_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,DISCOVERY_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,ABOUTME_FRAGMENT_TAG);
                        Fragment homeFragment = mFragments.get(0);
                        addFragment(R.id.fragment_container,homeFragment,fragmentManager,HOME_FRAGMENT_TAG);
                        break;
                    //shopping car
                    case 1:
                        hidenFragment(fragmentManager,HOME_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,DISCOVERY_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,ABOUTME_FRAGMENT_TAG);
                        Fragment shoppingCarFragment = mFragments.get(1);
                        addFragment(R.id.fragment_container,shoppingCarFragment,fragmentManager,SHOPPING_FRAGMENT_TAG);
                        break;
                    //discovery
                    case 2:
                        hidenFragment(fragmentManager,SHOPPING_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,HOME_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,ABOUTME_FRAGMENT_TAG);
                        Fragment discoveryFragment = mFragments.get(2);
                        addFragment(R.id.fragment_container,discoveryFragment,fragmentManager,DISCOVERY_FRAGMENT_TAG);
                        break;
                    //about me
                    case 3:
                        hidenFragment(fragmentManager,SHOPPING_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,DISCOVERY_FRAGMENT_TAG);
                        hidenFragment(fragmentManager,HOME_FRAGMENT_TAG);
                        Fragment aboutMeFragment = mFragments.get(3);
                        addFragment(R.id.fragment_container,aboutMeFragment,fragmentManager,ABOUTME_FRAGMENT_TAG);
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //????tab
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(R.layout.bottom_menu_firtpage).setTag(HOME_FRAGMENT_TAG).setText(R.string.firstpage).setIcon(R.drawable.bottom_action_home));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(R.layout.bottom_menu_shoppingcar).setTag(SHOPPING_FRAGMENT_TAG).setText(R.string.shoppingcar).setIcon(R.drawable.bottom_action_shoping));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(R.layout.bottom_menu_discovery).setTag(DISCOVERY_FRAGMENT_TAG).setText(R.string.disnew).setIcon(R.drawable.bottom_action_discovery));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(R.layout.bottom_menu_aboutme).setTag(ABOUTME_FRAGMENT_TAG).setText(R.string.aboutme).setIcon(R.drawable.action_profile));
    }

    private void  hidenFragment(FragmentManager fragmentManager,String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment f = fragmentManager.findFragmentByTag(tag);
        if(f!=null) {
            fragmentTransaction.hide(f);
            fragmentTransaction.commit();
        }
    }
    private void addFragment(int containerResourceId,Fragment fragment,FragmentManager fragmentManager,String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(fragment.isAdded() && fragment.isHidden()) {
            fragmentTransaction.show(fragment);
        }else {
            fragmentTransaction.add(containerResourceId,fragment,tag);
        }
        fragmentTransaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
