

package com.ibm.mobileappbuilder.pkg20170123065314.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.pkg20170123065314.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import com.ibm.mobileappbuilder.pkg20170123065314.ds.Item;
import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * LabInventoryFragment menu fragment.
 */
public class LabInventoryFragment extends ibmmobileappbuilder.ui.MenuFragment {
    private Item item;
    /**
     * Default constructor
     */
    public LabInventoryFragment(){
        super();
    }

    // Factory method
    public static LabInventoryFragment newInstance(Bundle args) {
        LabInventoryFragment fragment = new LabInventoryFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        item = getArguments() != null && getArguments().containsKey(Item.class.getName()) ? 
        	(Item)getArguments().getParcelable(Item.class.getName()) : 
        	new Item();
    }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Resistors")
            .setIcon(R.drawable.resis)
            .setAction(new StartActivityAction(ResistorsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("IC's")
            .setIcon(R.drawable.jpg_integratedcircuit250x2507)
            .setAction(new StartActivityAction(ICsMenuItem1Activity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Capacitors & Inductors")
            .setIcon(R.drawable.capacitor)
            .setAction(new StartActivityAction(CapacitorsInductorsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Devlopment Boards")
            .setIcon(R.drawable.devboard)
            .setAction(new StartActivityAction(DevlopmentBoardsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Miscellanous")
            .setIcon(R.drawable.mis)
            .setAction(new StartActivityAction(MiscellanousActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.labinventory_item;
    }
}
