package com.sinyuk.utils;

import retrofit2.Response;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public class ErrorCheckerTransformer<T extends Response<R>, R>
        implements Observable.Transformer<T, R> {

    private static final String DEFAULT_ERROR_MESSAGE = "Oh, no";


    @Override
    public Observable<R> call(Observable<T> observable) {
        return observable.map(
                new Func1<T, R>() {
                    @Override
                    public R call(T t) {
                        String msg = null;
                        if (!t.isSuccessful() || t.body() == null) {
                            msg = DEFAULT_ERROR_MESSAGE;
                            if (t.message() != null)
                                msg = t.message();
                        }

                        if (msg != null) {
                            try {
                                throw new ErrorResponseException(msg);
                            } catch (ErrorResponseException e) {
                                throw Exceptions.propagate(e);
                            }
                        }
                        return t.body();
                    }
                }
        );
    }
}