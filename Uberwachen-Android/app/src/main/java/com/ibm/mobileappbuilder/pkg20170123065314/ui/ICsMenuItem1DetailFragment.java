
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
import com.ibm.mobileappbuilder.pkg20170123065314.ds.Sheet1Schema2Item;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.ICsDS;

public class ICsMenuItem1DetailFragment extends ibmmobileappbuilder.ui.DetailFragment<Sheet1Schema2Item> implements ShareBehavior.ShareListener  {

    private Datasource<Sheet1Schema2Item> datasource;
    public static ICsMenuItem1DetailFragment newInstance(Bundle args){
        ICsMenuItem1DetailFragment fr = new ICsMenuItem1DetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public ICsMenuItem1DetailFragment(){
        super();
    }

    @Override
    public Datasource<Sheet1Schema2Item> getDatasource() {
        if (datasource != null) {
            return datasource;
    }
       datasource = ICsDS.getInstance(new SearchOptions());
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
        return R.layout.icsmenuitem1detail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Sheet1Schema2Item item, View view) {
        if (item.name != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.name);
            
        }
        if (item.code != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText("Code : " + StringUtils.doubleToString(item.code, true));
            
        }
        if (item.quantity != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText("Available Quantity : " + StringUtils.doubleToString(item.quantity, true));
            
        }
        
        TextView view3 = (TextView) view.findViewById(R.id.view3);
        view3.setText("Link to data sheet");
        ColorUtils.tintIcon(view3.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view3, new OpenUriAction(new ActivityIntentLauncher(), item.datasheet));
        
        TextView view4 = (TextView) view.findViewById(R.id.view4);
        view4.setText("Click Here to Request Order");
        ColorUtils.tintIcon(view4.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view4, new MailAction(new ActivityIntentLauncher(), "uberwacheniith@iith.ac.in"));
    }

    @Override
    protected void onShow(Sheet1Schema2Item item) {
        // set the title for this fragment
        getActivity().setTitle(item.name + "-" + StringUtils.doubleToString(item.code, true));
    }
    @Override
    public void onShare() {
        Sheet1Schema2Item item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.name != null ? item.name : "" ) + "\n" +
                    (item.code != null ? "Code : " + StringUtils.doubleToString(item.code, true) : "" ) + "\n" +
                    (item.quantity != null ? "Available Quantity : " + StringUtils.doubleToString(item.quantity, true) : "" ) + "\n" +
                    "Link to data sheet" + "\n" +
                    "Click Here to Request Order");
        intent.putExtra(Intent.EXTRA_SUBJECT, item.name + "-" + StringUtils.doubleToString(item.code, true));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}
