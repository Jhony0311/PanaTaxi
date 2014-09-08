package com.jhony.panataxi.panataxi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by Flia Ortega on 03/02/14.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public SectionsPagerAdapter(FragmentManager fm, Context c) {
        super(fm);
        context = c;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a DummySectionFragment (defined as a static inner class
        // below) with the page number as its lone argument.

        Bundle args = new Bundle();
        args.putInt(LocationFragment.ARG_SECTION_NUMBER, position + 1);

        switch (position) {
            case 0:
                android.support.v4.app.Fragment fragment1 = new LocationFragment();
                fragment1.setArguments(args);
                return fragment1;
            case 1:
                android.support.v4.app.Fragment fragment2 = new DateHourFragment();
                fragment2.setArguments(args);
                return fragment2;
            case 2:
                android.support.v4.app.Fragment fragment3 = new DetailsFragment();
                fragment3.setArguments(args);
                return fragment3;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();

        switch (position) {
            case 0:
                return context.getString(R.string.title_location).toUpperCase(l);
            case 1:
                return context.getString(R.string.title_datehour).toUpperCase(l);
            case 2:
                return context.getString(R.string.title_details).toUpperCase(l);
        }
        return null;
    }
}

