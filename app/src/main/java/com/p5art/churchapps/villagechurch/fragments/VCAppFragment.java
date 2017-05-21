package com.p5art.churchapps.villagechurch.fragments;

import android.support.v4.app.Fragment;

import com.p5art.churchapps.villagechurch.R;
import com.p5art.churchapps.villagechurch.VCApp;


/**
 * Created by UN on 29/4/17.
 */

public abstract class VCAppFragment extends Fragment {
    public abstract String getFragmentName();
    public String getAppNameFragmentName(){
        String appName = VCApp.getContext().getString(R.string.app_name);
        return appName + " | " + getFragmentName();
    }
}
