package com.example.besafe;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class tabpagerAdapter extends FragmentStatePagerAdapter {

    String[] tabarray = new String[]{"Stories", "Explore"};

    Integer tabnumber = 2;

    public tabpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Stories stories = new Stories();
                return stories;
            case 1:
                Explore explore = new Explore();
                return explore;
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
