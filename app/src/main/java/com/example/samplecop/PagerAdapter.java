package com.example.samplecop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int NumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.NumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            TabFragment1 tab1 = new TabFragment1();
            return tab1;
        }
        if (position == 1) {
            if (NumOfTabs == 3) {
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            } else {
                TabFragment3 tab2 = new TabFragment3();
                return tab2;
            }
        }
        if (position == 2) {
            TabFragment3 tab3 = new TabFragment3();
            return tab3;
        }
                return null;
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}