
package com.ibm.mobileappbuilder.pkg20170123065314.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pkg20170123065314.R;
import ibmmobileappbuilder.actions.ActivityIntentLauncher;
import ibmmobileappbuilder.actions.MailAction;
import ibmmobileappbuilder.actions.OpenUriAction;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.util.ColorUtils;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.Sheet1Schema4Item;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.CIDS;

public class CapacitorsInductorsDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<Sheet1Schema4Item> implements ShareBehavior.ShareListener  {

    private Datasource<Sheet1Schema4Item> datasource;
    public static CapacitorsInductorsDetailFragment newInstance(Bundle args){
        CapacitorsInductorsDetailFragment fr = new CapacitorsInductorsDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public CapacitorsInductorsDetailFragment(){
        super();
    }

    @Override
    public Datasource<Sheet1Schema4Item> getDatasource() {
        if (datasource != null) {
            return datasource;
    }
       datasource = CIDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.capacitorsinductorsdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Sheet1Schema4Item item, View view) {
        if (item.type != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.type);
            
        }
        if (item.name != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText("Value : " + item.name);
            
        }
        if (item.quantity != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText("Quantity : " + StringUtils.doubleToString(item.quantity, true));
            
        }
        
        TextView view3 = (TextView) view.findViewById(R.id.view3);
        view3.setText("Link to Image ( Color for Inductor)");
        ColorUtils.tintIcon(view3.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view3, new OpenUriAction(new ActivityIntentLauncher(), item.picture));
        
        TextView view4 = (TextView) view.findViewById(R.id.view4);
        view4.setText("Click Here to Request Order");
        ColorUtils.tintIcon(view4.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view4, new MailAction(new ActivityIntentLauncher(), "uberwacheniith@iith.ac.in"));
    }

    @Override
    protected void onShow(Sheet1Schema4Item item) {
        // set the title for this fragment
        getActivity().setTitle(item.type + ":" + item.name);
    }
    @Override
    public void onShare() {
        Sheet1Schema4Item item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.type != null ? item.type : "" ) + "\n" +
                    (item.name != null ? "Value : " + item.name : "" ) + "\n" +
                    (item.quantity != null ? "Quantity : " + StringUtils.doubleToString(item.quantity, true) : "" ) + "\n" +
                    "Link to Image ( Color for Inductor)" + "\n" +
                    "Click Here to Request Order");
        intent.putExtra(Intent.EXTRA_SUBJECT, item.type + ":" + item.name);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}
