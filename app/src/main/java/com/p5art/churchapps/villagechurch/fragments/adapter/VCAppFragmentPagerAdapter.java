package com.p5art.churchapps.villagechurch.fragments.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by UN on 29/4/17.
 */

public class VCAppFragmentPagerAdapter extends FragmentPagerAdapter {
    private static String TAG = VCAppFragmentPagerAdapter.class.getSimpleName();

    public VCAppFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return FragmentUIAdapterManager.getInstance().getFragmentCount();
    }

    @Override
    public Fragment getItem(int position) {
        FragmentUIAdapter fragmentUIAdapter = FragmentUIAdapterManager.getInstance().getFragmentIdentityBySequence(position);

        Class classOfFragment = fragmentUIAdapter.getFragmentClass();
        Constructor<Fragment>[] constructors = classOfFragment.getConstructors();
        Constructor<Fragment> constructor = constructors[0];

        Fragment fragment = null;
        try {
            fragment = constructor.newInstance(null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return fragment;
    }
}
