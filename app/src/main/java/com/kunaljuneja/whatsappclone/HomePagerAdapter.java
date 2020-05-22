package com.kunaljuneja.whatsappclone;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private Fragment[] myFragmentList;
    private int[] titleList;
    Context mContext;

    public HomePagerAdapter(FragmentManager manager, Context context, int behavior, Fragment[] myList, int[] titleList){
        super(manager, behavior);
        this.myFragmentList = myList;
        this.titleList = titleList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragmentList[position];
    }

    @Override
    public int getCount() {
        return myFragmentList.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(titleList[position]);
    }
}
