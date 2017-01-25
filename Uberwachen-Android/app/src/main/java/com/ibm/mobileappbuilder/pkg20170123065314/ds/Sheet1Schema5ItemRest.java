
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface Sheet1Schema5ItemRest {

    @GET("/ffc0145e-5990-474a-9a56-4807c0897896")
    void getAll(Callback<List<Sheet1Schema5Item>> cb);

    @GET("/ffc0145e-5990-474a-9a56-4807c0897896")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<Sheet1Schema5Item>> cb);

    @GET("/ffc0145e-5990-474a-9a56-4807c0897896/{rowId}")
    void getItem(String rowId, Callback<Sheet1Schema5Item> cb);

    @GET("/ffc0145e-5990-474a-9a56-4807c0897896/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

