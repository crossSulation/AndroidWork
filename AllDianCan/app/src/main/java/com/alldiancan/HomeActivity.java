package com.alldiancan;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import java.util.zip.Inflater;


public class HomeActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private Fragment []mFragments;
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

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //????tab
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_firtpage, mTabLayout)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_shoppingcar,mTabLayout)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_discovery,mTabLayout)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(LayoutInflater.from(this).inflate(R.layout.bottom_menu_aboutme,mTabLayout)));
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
