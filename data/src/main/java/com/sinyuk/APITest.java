package com.sinyuk;

import com.sinyuk.entities.Timeline;
import com.sinyuk.remote.Endpoint;
import com.sinyuk.remote.OauthManager;
import com.sinyuk.remote.RemoteDataSource;

import rx.Observer;

import static com.sinyuk.API.END_POINT;
import static com.sinyuk.API.OAUTH;

public class APITest {
    public static void main(String[] args) {
        Endpoint endpoint = new Endpoint(END_POINT);
        Endpoint endpoint2 = new Endpoint(OAUTH);

        RemoteDataSource remoteDataSource = new RemoteDataSource(endpoint, "2.00MlrnQD0sdoPv864caed419nQccYE", null);
        test(remoteDataSource);

        OauthManager oauthManager = new OauthManager(endpoint2);
    }

    private static void test(RemoteDataSource remoteDataSource) {
        System.out.println("test");

        remoteDataSource.friends_timeline(null, null)
                .subscribe(new Observer<Timeline>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Timeline timeline) {
                        System.out.println("onNext");
                    }
                });
    }
}
