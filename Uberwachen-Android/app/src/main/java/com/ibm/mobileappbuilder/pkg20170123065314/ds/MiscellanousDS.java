
package com.ibm.mobileappbuilder.pkg20170123065314.ds;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.restds.RestDatasource;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.ibm.mobileappbuilder.pkg20170123065314.R;

import static ibmmobileappbuilder.injectors.ApplicationInjector.getApplicationContext;

/**
 * "MiscellanousDS" data source. (ffc0145e-5990-474a-9a56-4807c0897896)
 */
public class MiscellanousDS extends RestDatasource<Sheet1Schema5Item, Sheet1Schema5ItemRest> implements
    Pagination<Sheet1Schema5Item>, Distinct {

    // default page size
    private static final int PAGE_SIZE = 20;

    private Context context;

    public static MiscellanousDS getInstance(SearchOptions searchOptions){
        return new MiscellanousDS(getApplicationContext(), searchOptions);
    }

    private MiscellanousDS(Context context, SearchOptions searchOptions) {
        super(Sheet1Schema5ItemRest.class, searchOptions);
        this.context = context;
    }

    @Override
    public void getItems(final Listener<List<Sheet1Schema5Item>> listener) {
                getServiceProxy().getAll(new Callback<List<Sheet1Schema5Item>>() {
            @Override
            public void success(List<Sheet1Schema5Item> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void getItem(String id, final Listener<Sheet1Schema5Item> listener) {
              // query first item
        getServiceProxy().search(null, null, true, 0, 1, null, new Callback<List<Sheet1Schema5Item>>() {
            @Override
            public void success(List<Sheet1Schema5Item> result, Response response) {
                                if (result.size() > 0) {
                    listener.onSuccess(result.get(0));
                } else {
                    listener.onSuccess(new Sheet1Schema5Item());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void getItems(int pagenum, final Listener<List<Sheet1Schema5Item>> listener) {
        String filter = getFilterQuery(searchOptions);
                getServiceProxy().search(searchOptions.getSearchText(), searchOptions.getSortColumn(), searchOptions.isSortAscending(),
                pagenum, PAGE_SIZE, filter, new Callback<List<Sheet1Schema5Item>>() {
            @Override
            public void success(List<Sheet1Schema5Item> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public String getServerUrl(){
        return context.getString(R.string.dynamic_url);
    }

    @Override
    protected String getApiKey(){
        String apikey = context.getString(R.string.api_key);
        return "NoApiKey".equals(apikey) ? null : apikey;
    }

    @Override
    protected String getAppId(){
        return context.getString(R.string.app_id);
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String condition = getFilterQuery(searchOptions);
                getServiceProxy().getDistinctValues(searchStr, condition, new Callback<List<String>>() {
            @Override
            public void success(List<String> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }
}

