
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface Sheet1Schema3ItemRest {

    @GET("/243b010a-e5df-4803-8570-ccb3be714d6f")
    void getAll(Callback<List<Sheet1Schema3Item>> cb);

    @GET("/243b010a-e5df-4803-8570-ccb3be714d6f")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<Sheet1Schema3Item>> cb);

    @GET("/243b010a-e5df-4803-8570-ccb3be714d6f/{rowId}")
    void getItem(String rowId, Callback<Sheet1Schema3Item> cb);

    @GET("/243b010a-e5df-4803-8570-ccb3be714d6f/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

