
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface Sheet1Schema1ItemRest {

    @GET("/5a7f9aa5-bc7f-4c1d-ba83-2697b05e99a2")
    void getAll(Callback<List<Sheet1Schema1Item>> cb);

    @GET("/5a7f9aa5-bc7f-4c1d-ba83-2697b05e99a2")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<Sheet1Schema1Item>> cb);

    @GET("/5a7f9aa5-bc7f-4c1d-ba83-2697b05e99a2/{rowId}")
    void getItem(String rowId, Callback<Sheet1Schema1Item> cb);

    @GET("/5a7f9aa5-bc7f-4c1d-ba83-2697b05e99a2/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

