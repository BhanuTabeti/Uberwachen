package com.ibm.mobileappbuilder.pkg20170123065314.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pkg20170123065314.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.util.ViewHolder;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.Sheet1Schema4Item;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.CIDS;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;
import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "CapacitorsInductorsFragment" listing
 */
public class CapacitorsInductorsFragment extends ListGridFragment<Sheet1Schema4Item>  {

    private Datasource<Sheet1Schema4Item> datasource;


    public static CapacitorsInductorsFragment newInstance(Bundle args) {
        CapacitorsInductorsFragment fr = new CapacitorsInductorsFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
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
        return R.layout.capacitorsinductors_item;
    }

    @Override
    protected Datasource<Sheet1Schema4Item> getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = CIDS.getInstance(getSearchOptions());
        return datasource;
    }

    @Override
    protected void bindView(Sheet1Schema4Item item, View view, int position) {
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.type != null && item.name != null){
            title.setText(item.type + " : " + item.name);
            
        }
        
        TextView subtitle = ViewHolder.get(view, R.id.subtitle);
        
        if (item.quantity != null){
            subtitle.setText("Available Quantity : " + StringUtils.doubleToString(item.quantity, true));
            
        }
    }


    @Override
    public void showDetail(Sheet1Schema4Item item, int position) {
        // If we have forms, then we have to refresh when an item has been edited
        // Also with this we support list without details
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), CapacitorsInductorsDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}
