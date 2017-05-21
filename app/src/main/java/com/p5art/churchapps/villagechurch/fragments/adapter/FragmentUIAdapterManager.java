package com.p5art.churchapps.villagechurch.fragments.adapter;

import com.p5art.churchapps.villagechurch.R;
import com.p5art.churchapps.villagechurch.fragments.CalendarFragment;
import com.p5art.churchapps.villagechurch.fragments.ContactUsFragment;
import com.p5art.churchapps.villagechurch.fragments.PrayerFragment;
import com.p5art.churchapps.villagechurch.fragments.StudiesFragment;
import com.p5art.churchapps.villagechurch.fragments.TalksFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UN on 29/4/17.
 */

public class FragmentUIAdapterManager {
    private static final FragmentUIAdapterManager ourInstance = new FragmentUIAdapterManager();

    public static FragmentUIAdapterManager getInstance() {
        return ourInstance;
    }

    List<FragmentUIAdapter> fragmentUIAdapterList = null;

    private FragmentUIAdapterManager() {
        fragmentUIAdapterList = new ArrayList<>();

        int sequence = 0;

        fragmentUIAdapterList.add(new FragmentUIAdapter(TalksFragment.class, sequence++, R.id.navigation_1));
        fragmentUIAdapterList.add(new FragmentUIAdapter(CalendarFragment.class, sequence++, R.id.navigation_2));
        fragmentUIAdapterList.add(new FragmentUIAdapter(StudiesFragment.class, sequence++, R.id.navigation_3));
        fragmentUIAdapterList.add(new FragmentUIAdapter(PrayerFragment.class, sequence++, R.id.navigation_4));
        fragmentUIAdapterList.add(new FragmentUIAdapter(ContactUsFragment.class, sequence++, R.id.navigation_5));
    }

    public FragmentUIAdapter getFragmentIdentityBySequence(int sequence) {
        for (FragmentUIAdapter fragmentUIAdapter : fragmentUIAdapterList) {
            if(fragmentUIAdapter.getSequence() == sequence){
                return fragmentUIAdapter;
            }
        }

        return null;
    }

    public FragmentUIAdapter getFragmentIdentityByNavigationId(int navigationItemId) {
        for (FragmentUIAdapter fragmentUIAdapter : fragmentUIAdapterList) {
            if(fragmentUIAdapter.getNavigationItemId() == navigationItemId){
                return fragmentUIAdapter;
            }
        }

        return null;
    }

    public int getFragmentCount(){
        return fragmentUIAdapterList.size();
    }

}
