package com.ibm.mobileappbuilder.pkg20170123065314.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pkg20170123065314.R;
import ibmmobileappbuilder.behaviors.SearchBehavior;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.util.ViewHolder;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.Sheet1Schema1Item;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.ResistorsDS;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;
import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "ResistorsFragment" listing
 */
public class ResistorsFragment extends ListGridFragment<Sheet1Schema1Item>  {

    private Datasource<Sheet1Schema1Item> datasource;


    public static ResistorsFragment newInstance(Bundle args) {
        ResistorsFragment fr = new ResistorsFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addBehavior(new SearchBehavior(this));
        
    }

    protected SearchOptions getSearchOptions() {
        SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
        return searchOptionsBuilder.build();
    }


    /**
    * Layout for the list itselft
    */
    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    /**
    * Layout for each element in the list
    */
    @Override
    protected int getItemLayout() {
        return R.layout.resistors_item;
    }

    @Override
    protected Datasource<Sheet1Schema1Item> getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = ResistorsDS.getInstance(getSearchOptions());
        return datasource;
    }

    @Override
    protected void bindView(Sheet1Schema1Item item, View view, int position) {
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.name != null){
            title.setText("Value : " + item.name);
            
        }
        
        TextView subtitle = ViewHolder.get(view, R.id.subtitle);
        
        if (item.quantity != null){
            subtitle.setText("Available Quantity : " + StringUtils.doubleToString(item.quantity, true));
            
        }
    }


    @Override
    public void showDetail(Sheet1Schema1Item item, int position) {
        // If we have forms, then we have to refresh when an item has been edited
        // Also with this we support list without details
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), ResistorsDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}
