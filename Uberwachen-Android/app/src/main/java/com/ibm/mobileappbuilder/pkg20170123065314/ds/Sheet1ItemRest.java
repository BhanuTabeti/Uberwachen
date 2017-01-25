
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface Sheet1ItemRest {

    @GET("/49265ab8-499c-4704-b2f2-2822ea5c5c87")
    void getAll(Callback<List<Sheet1Item>> cb);

    @GET("/49265ab8-499c-4704-b2f2-2822ea5c5c87")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<Sheet1Item>> cb);

    @GET("/49265ab8-499c-4704-b2f2-2822ea5c5c87/{rowId}")
    void getItem(String rowId, Callback<Sheet1Item> cb);

    @GET("/49265ab8-499c-4704-b2f2-2822ea5c5c87/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

