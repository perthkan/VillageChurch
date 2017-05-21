package com.p5art.churchapps.villagechurch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.p5art.churchapps.villagechurch.R;
import com.p5art.churchapps.villagechurch.VCApp;

/**
 * Created by UN on 28/4/17.
 */

public class PrayerFragment extends VCAppFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prayer, container, false);
    }

    @Override
    public String getFragmentName() {
        return VCApp.getContext().getString(R.string.prayer);
    }
}
