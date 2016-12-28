package com.sinyuk;

import com.sinyuk.entities.User;
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
        long id = 2996704602L;
        remoteDataSource.users_show(id)
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(User user) {

                    }
                });
    }
}
