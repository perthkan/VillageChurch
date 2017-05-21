package com.p5art.churchapps.villagechurch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.p5art.churchapps.villagechurch.fragments.VCAppFragment;
import com.p5art.churchapps.villagechurch.fragments.adapter.FragmentUIAdapter;
import com.p5art.churchapps.villagechurch.fragments.adapter.FragmentUIAdapterManager;
import com.p5art.churchapps.villagechurch.fragments.adapter.VCAppFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    VCAppFragmentPagerAdapter vcAppFragmentPagerAdapter;
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            FragmentUIAdapter fragmentUIAdapter = FragmentUIAdapterManager.getInstance().getFragmentUIAdapterByNavigationItemId(id);

            if(fragmentUIAdapter != null) {
                int pageIndex = fragmentUIAdapter.getSequence();
                viewPager.setCurrentItem(pageIndex, true);
                return true;
            }

            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        vcAppFragmentPagerAdapter = new VCAppFragmentPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(vcAppFragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateActionBarTitle();

                FragmentUIAdapter fragmentUIAdapter = FragmentUIAdapterManager.getInstance().getFragmentUIAdapterBySequence(position);

                if(fragmentUIAdapter != null) {
                    int navigationItemID = fragmentUIAdapter.getNavigationItemId();
                    bottomNavigationView.setSelectedItemId(navigationItemID);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateActionBarTitle();
    }

    private void updateActionBarTitle() {
        int position = viewPager.getCurrentItem();
        VCAppFragment vcAppFragment = (VCAppFragment)vcAppFragmentPagerAdapter.getItem(position);
        getSupportActionBar().setTitle(vcAppFragment.getAppNameFragmentName());
    }





}
