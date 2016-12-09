package com.sinyuk.utils;

/**
 * Created by sinyuk on 2016/11/8.
 */

import com.sinyuk.remote.BaseResponse;

import rx.Observable;
import rx.functions.Func1;

/**
 * 用来统一处理success = false的响应
 *
 * @param <T>
 */
public final class ResponseFunc<T> implements Func1<BaseResponse<T>, Observable<T>> {

    @Override
    public Observable<T> call(BaseResponse<T> response) {
        return Observable.just(response.getData());
    }
}



