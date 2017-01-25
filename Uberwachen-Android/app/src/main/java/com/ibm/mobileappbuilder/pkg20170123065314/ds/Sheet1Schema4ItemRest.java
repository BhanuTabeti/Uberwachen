
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface Sheet1Schema4ItemRest {

    @GET("/f036a821-ef4a-445d-8394-da6731d4de46")
    void getAll(Callback<List<Sheet1Schema4Item>> cb);

    @GET("/f036a821-ef4a-445d-8394-da6731d4de46")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<Sheet1Schema4Item>> cb);

    @GET("/f036a821-ef4a-445d-8394-da6731d4de46/{rowId}")
    void getItem(String rowId, Callback<Sheet1Schema4Item> cb);

    @GET("/f036a821-ef4a-445d-8394-da6731d4de46/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}

