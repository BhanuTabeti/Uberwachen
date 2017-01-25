
package com.ibm.mobileappbuilder.pkg20170123065314.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.pkg20170123065314.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.ImageView;
import android.widget.TextView;
import ibmmobileappbuilder.actions.NavigateToAction;
import ibmmobileappbuilder.util.ColorUtils;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.Item;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.EmptyDatasource;

public class HomeFragment extends ibmmobileappbuilder.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    private SearchOptions searchOptions;

    public static HomeFragment newInstance(Bundle args){
        HomeFragment card = new HomeFragment();
        card.setArguments(args);

        return card;
    }

    public HomeFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = EmptyDatasource.getInstance(searchOptions);
        return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.home_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
        
        ImageView view0 = (ImageView) view.findViewById(R.id.view0);
        ImageLoader view0Loader = new PicassoImageLoader(view.getContext());
        view0Loader.load(imageLoaderRequest()
                        .withResourceToLoad(R.drawable.png_screenshotfrom20170124001)
                        .withTargetView(view0)
                        .build()
        );
        
        
        
        TextView view2 = (TextView) view.findViewById(R.id.view2);
        view2.setText("Lab Inventory");
        bindAction(view2, new NavigateToAction(Item.class.getName(), LabInventoryActivity.class, getItem()));

        ImageView view2_icon = (ImageView) view.findViewById(R.id.view2_icon);
        bindAction(view2_icon, new NavigateToAction(Item.class.getName(), LabInventoryActivity.class, getItem()));
        
        TextView view4 = (TextView) view.findViewById(R.id.view4);
        view4.setText("Bus schedule");
        bindAction(view4, new NavigateToAction(Item.class.getName(), BusScheduleActivity.class, getItem()));

        ImageView view4_icon = (ImageView) view.findViewById(R.id.view4_icon);
        bindAction(view4_icon, new NavigateToAction(Item.class.getName(), BusScheduleActivity.class, getItem()));
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle("Uberwachen");
    }
}
