package com.example.grumpybunny.tourguideapp;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * this is the Category Adapter class that manages the fragments in the tabLayout
 */

public class CategoryAdapter extends FragmentStatePagerAdapter {

    public static List<String> fragmentTitle = new ArrayList<>();
    // Initialize lists to hold Fragments
    private final List<Fragment> fragmentList = new ArrayList<>();
    private Context catContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.catContext = context;
    }

    // A method to add Fragments to the Fragments list
    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
