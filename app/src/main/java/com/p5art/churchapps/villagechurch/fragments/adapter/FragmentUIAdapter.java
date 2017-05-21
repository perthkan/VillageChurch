package com.p5art.churchapps.villagechurch.fragments.adapter;

import android.support.v4.app.Fragment;

/**
 * Created by UN on 29/4/17.
 */

public class FragmentUIAdapter {
    private Class<? extends Fragment> fragmentClass = null;

    private int sequence;

    private int navigationItemId;

    /**
     *
     * @param fragmentClass the class of the fragment
     * @param sequence 1, 2, 3, ...
     * @param navigationItemId R.id.something
     */
    public FragmentUIAdapter(Class<? extends Fragment> fragmentClass , int sequence, int navigationItemId){
        this.fragmentClass = fragmentClass;
        this.sequence = sequence;
        this.navigationItemId = navigationItemId;
    }

    /**
     * the class of the fragment
     */
    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

    /**
     * 1, 2, 3, ...
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * R.id.something
     */
    public int getNavigationItemId() {
        return navigationItemId;
    }


}
