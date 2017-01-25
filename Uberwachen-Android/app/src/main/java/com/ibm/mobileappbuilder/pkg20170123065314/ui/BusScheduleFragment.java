

package com.ibm.mobileappbuilder.pkg20170123065314.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.pkg20170123065314.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;


/**
 * BusScheduleFragment menu fragment.
 */
public class BusScheduleFragment extends ibmmobileappbuilder.ui.MenuFragment {
    /**
     * Default constructor
     */
    public BusScheduleFragment(){
        super();
    }

    // Factory method
    public static BusScheduleFragment newInstance(Bundle args) {
        BusScheduleFragment fragment = new BusScheduleFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public int getItemLayout() {
        return R.layout.busschedule_item;
    }
}
