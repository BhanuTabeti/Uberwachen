

package com.ibm.mobileappbuilder.pkg20170123065314.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.pkg20170123065314.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * MiscellanousActivity list activity
 */
public class MiscellanousActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        if(isTaskRoot()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        setTitle(getString(R.string.miscellanousActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return MiscellanousFragment.class;
    }

}
