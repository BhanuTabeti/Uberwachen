
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
import com.ibm.mobileappbuilder.pkg20170123065314.ds.Sheet1Schema5Item;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.MiscellanousDS;

public class MiscellanousDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<Sheet1Schema5Item> implements ShareBehavior.ShareListener  {

    private Datasource<Sheet1Schema5Item> datasource;
    public static MiscellanousDetailFragment newInstance(Bundle args){
        MiscellanousDetailFragment fr = new MiscellanousDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public MiscellanousDetailFragment(){
        super();
    }

    @Override
    public Datasource<Sheet1Schema5Item> getDatasource() {
        if (datasource != null) {
            return datasource;
    }
       datasource = MiscellanousDS.getInstance(new SearchOptions());
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
        return R.layout.miscellanousdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Sheet1Schema5Item item, View view) {
        if (item.instruments != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.instruments);
            
        }
        if (item.quantity != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText("Available Quantity : " + StringUtils.doubleToString(item.quantity, true));
            
        }
        
        TextView view2 = (TextView) view.findViewById(R.id.view2);
        view2.setText("Link to Image");
        ColorUtils.tintIcon(view2.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view2, new OpenUriAction(new ActivityIntentLauncher(), item.picture));
        
        TextView view3 = (TextView) view.findViewById(R.id.view3);
        view3.setText("Click Here to request Order");
        ColorUtils.tintIcon(view3.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view3, new MailAction(new ActivityIntentLauncher(), "uberwacheniith@iith.ac.in"));
    }

    @Override
    protected void onShow(Sheet1Schema5Item item) {
        // set the title for this fragment
        getActivity().setTitle(item.instruments);
    }
    @Override
    public void onShare() {
        Sheet1Schema5Item item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.instruments != null ? item.instruments : "" ) + "\n" +
                    (item.quantity != null ? "Available Quantity : " + StringUtils.doubleToString(item.quantity, true) : "" ) + "\n" +
                    "Link to Image" + "\n" +
                    "Click Here to request Order");
        intent.putExtra(Intent.EXTRA_SUBJECT, item.instruments);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}
