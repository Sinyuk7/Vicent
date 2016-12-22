package com.sinyuk.remote;

import com.sinyuk.entities.Feature;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public interface PxService {
    @GET("photos?image_size=440,600,1080?tags=true")
    Observable<Response<Feature>> getPhotos(
            @Query("feature") String feature,
            @Query("only") String categories,
            @Query("sort") String sort,
            @Query("sort_direction") String sort_direction,
            @Query("page") int page);
}
