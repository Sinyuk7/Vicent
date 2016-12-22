package com.sinyuk;

import com.sinyuk.entities.Feature;
import com.sinyuk.remote.Endpoint;
import com.sinyuk.remote.RemoteDataSource;

import rx.Observer;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

import static com.sinyuk.remote.API.CONSUMER_KEY;
import static com.sinyuk.remote.API.CONSUMER_SECRET;
import static com.sinyuk.remote.API.END_POINT;

public class APITest {
    public static void main(String[] args) {
        Endpoint endpoint = new Endpoint(END_POINT);
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        SigningInterceptor signingInterceptor = new SigningInterceptor(consumer);
        RemoteDataSource remoteDataSource = new RemoteDataSource(endpoint, signingInterceptor, null);
        test(remoteDataSource);
    }

    private static void test(RemoteDataSource remoteDataSource) {
        System.out.println("test");

        remoteDataSource.photoByFeature("popular", "", "", "", 1)
                .subscribe(new Observer<Feature>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Feature feature) {
                        System.out.println(feature.toString());
                    }
                });
    }
}
