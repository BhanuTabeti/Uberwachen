
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ODFKANDIWEEKDAYSCHEDULESchema1ItemRest {

    @GET("/70d91722-2f66-4f35-9ba0-7a54667fe6fb")
    void getAll(Callback<List<ODFKANDIWEEKDAYSCHEDULESchema1Item>> cb);

    @GET("/70d91722-2f66-4f35-9ba0-7a54667fe6fb")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<ODFKANDIWEEKDAYSCHEDULESchema1Item>> cb);

    @GET("/70d91722-2f66-4f35-9ba0-7a54667fe6fb/{rowId}")
    void getItem(String rowId, Callback<ODFKANDIWEEKDAYSCHEDULESchema1Item> cb);

    @GET("/70d91722-2f66-4f35-9ba0-7a54667fe6fb/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

