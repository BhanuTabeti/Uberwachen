
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
import com.ibm.mobileappbuilder.pkg20170123065314.ds.Sheet1Schema1Item;
import com.ibm.mobileappbuilder.pkg20170123065314.ds.ResistorsDS;

public class ResistorsDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<Sheet1Schema1Item> implements ShareBehavior.ShareListener  {

    private Datasource<Sheet1Schema1Item> datasource;
    public static ResistorsDetailFragment newInstance(Bundle args){
        ResistorsDetailFragment fr = new ResistorsDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public ResistorsDetailFragment(){
        super();
    }

    @Override
    public Datasource<Sheet1Schema1Item> getDatasource() {
        if (datasource != null) {
            return datasource;
    }
       datasource = ResistorsDS.getInstance(new SearchOptions());
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
        return R.layout.resistorsdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Sheet1Schema1Item item, View view) {
        if (item.name != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText("Resistor : " + item.name);
            
        }
        if (item.quantity != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText("Quanity Available : " + StringUtils.doubleToString(item.quantity, true));
            
        }
        
        TextView view2 = (TextView) view.findViewById(R.id.view2);
        view2.setText("Link to Color Code");
        ColorUtils.tintIcon(view2.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view2, new OpenUriAction(new ActivityIntentLauncher(), item.picture));
        
        TextView view3 = (TextView) view.findViewById(R.id.view3);
        view3.setText("Click Here to Request Order");
        ColorUtils.tintIcon(view3.getCompoundDrawables()[2], R.color.textColor, getActivity());
        bindAction(view3, new MailAction(new ActivityIntentLauncher(), "uberwacheniith@iith.ac.in"));
    }

    @Override
    protected void onShow(Sheet1Schema1Item item) {
        // set the title for this fragment
        getActivity().setTitle("Resistor - " + item.name);
    }
    @Override
    public void onShare() {
        Sheet1Schema1Item item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.name != null ? "Resistor : " + item.name : "" ) + "\n" +
                    (item.quantity != null ? "Quanity Available : " + StringUtils.doubleToString(item.quantity, true) : "" ) + "\n" +
                    "Link to Color Code" + "\n" +
                    "Click Here to Request Order");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Resistor-" + item.name);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}
