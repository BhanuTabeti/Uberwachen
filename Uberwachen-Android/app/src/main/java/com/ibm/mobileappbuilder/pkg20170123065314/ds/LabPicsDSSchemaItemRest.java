
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface LabPicsDSSchemaItemRest {

    @GET("/511f6824-d73b-46b2-9d0e-16a40bb535e8")
    void getAll(Callback<List<LabPicsDSSchemaItem>> cb);

    @GET("/511f6824-d73b-46b2-9d0e-16a40bb535e8")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<LabPicsDSSchemaItem>> cb);

    @GET("/511f6824-d73b-46b2-9d0e-16a40bb535e8/{rowId}")
    void getItem(String rowId, Callback<LabPicsDSSchemaItem> cb);

    @GET("/511f6824-d73b-46b2-9d0e-16a40bb535e8/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

