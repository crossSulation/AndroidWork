package com.alldiancan;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.alldiancan.fragments.AboutMeFragment;
import com.alldiancan.fragments.HomeFragment;
import com.alldiancan.fragments.HotFragment;
import com.alldiancan.fragments.ShoppingCarFragment;


public class HomeActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private Fragment []mFragments;
    private final String  HOME_FRAGMENT_TAG ="home";
    private final String  SHOPPING_FRAGMENT_TAG ="shopping";
    private final String  DISCOVERY_FRAGMENT_TAG ="discovery";
    private final String  ABOUTME_FRAGMENT_TAG ="aboutme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar =getActionBar();
        actionBar.hide();
        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout)findViewById(R.id.bottom_layout);


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            final FragmentManager fragmentManager = getFragmentManager();
            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    // first page
                    case 0:
                        if(fragmentManager.findFragmentByTag(HOME_FRAGMENT_TAG)!=null) {
                            fragmentTransaction.add(R.id.fragment_container, fragmentManager.findFragmentByTag(HOME_FRAGMENT_TAG));
                            fragmentTransaction.commit();
                        }else {
                            HomeFragment homeFragment = new HomeFragment();
                            fragmentTransaction.add(R.id.fragment_container, homeFragment);
                            fragmentTransaction.commit();
                        }
                        break;
                    //shopping car
                    case 1:
                        if(fragmentManager.findFragmentByTag(SHOPPING_FRAGMENT_TAG)!=null) {
                            fragmentTransaction.add(R.id.fragment_container, fragmentManager.findFragmentByTag(SHOPPING_FRAGMENT_TAG));
                            fragmentTransaction.commit();
                        }else {
                            ShoppingCarFragment shoppingCarFragment = new ShoppingCarFragment();
                            fragmentTransaction.add(R.id.fragment_container, shoppingCarFragment);
                            fragmentTransaction.commit();
                        }
                        break;
                    //discovery
                    case 2:
                        if(fragmentManager.findFragmentByTag(DISCOVERY_FRAGMENT_TAG)!=null) {
                            fragmentTransaction.add(R.id.fragment_container, fragmentManager.findFragmentByTag(DISCOVERY_FRAGMENT_TAG));
                            fragmentTransaction.commit();
                        }else {
                            HotFragment hotFragment = new HotFragment();
                            fragmentTransaction.add(R.id.fragment_container, hotFragment);
                            fragmentTransaction.commit();
                        }
                        break;
                    //about me
                    case 3:
                        if(fragmentManager.findFragmentByTag(ABOUTME_FRAGMENT_TAG)!=null) {
                            fragmentTransaction.add(R.id.fragment_container, fragmentManager.findFragmentByTag(ABOUTME_FRAGMENT_TAG));
                            fragmentTransaction.commit();
                        }else {
                            AboutMeFragment aboutmeFragment = new AboutMeFragment();
                            fragmentTransaction.add(R.id.fragment_container, aboutmeFragment);
                            fragmentTransaction.commit();
                        }
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
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_firtpage, mTabLayout)).setTag(HOME_FRAGMENT_TAG));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_shoppingcar,mTabLayout)).setTag(SHOPPING_FRAGMENT_TAG));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_discovery,mTabLayout)).setTag(DISCOVERY_FRAGMENT_TAG));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_aboutme,mTabLayout)).setTag(ABOUTME_FRAGMENT_TAG));
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
