
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface Sheet1Schema2ItemRest {

    @GET("/79076b77-2ec7-4bc9-a7eb-4bc831e04bb5")
    void getAll(Callback<List<Sheet1Schema2Item>> cb);

    @GET("/79076b77-2ec7-4bc9-a7eb-4bc831e04bb5")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<Sheet1Schema2Item>> cb);

    @GET("/79076b77-2ec7-4bc9-a7eb-4bc831e04bb5/{rowId}")
    void getItem(String rowId, Callback<Sheet1Schema2Item> cb);

    @GET("/79076b77-2ec7-4bc9-a7eb-4bc831e04bb5/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

