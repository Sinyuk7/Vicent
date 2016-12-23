package com.sinyuk.remote;

import com.sinyuk.entities.Photo;

import java.util.List;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public interface RemoteRepository {
    Observable<List<Photo>>  photoByFeature(String feature,
                                            String categories,
                                            String sort,
                                            String sort_direction,
                                            int page);
}
