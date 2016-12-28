package com.sinyuk;

import com.sinyuk.entities.User;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/27.
 */

public class GetPlayerUsecase extends Usecase<User> {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer<User> mSchedulerTransformer;

    @Named("uid")
    private final long uid;

    @Named("domain")
    @Nullable
    private final String domain;

    @Inject
    GetPlayerUsecase(RemoteRepository mRepository,
                     @Named("io_main") SchedulerTransformer mSchedulerTransformer,
                     @Named("uid") long uid,
                     @Nullable @Named("domain") String domain) {
        this.mRepository = mRepository;
        this.mSchedulerTransformer = mSchedulerTransformer;
        this.uid = uid;
        this.domain = domain;
    }

    public long getUid() {
        return uid;
    }

    public String getDomain() {
        return domain;
    }

    public Observable<User> execute() {
        return buildObservable();
    }

    @Override
    protected Observable<User> buildObservable() {
        if (domain != null)
            return mRepository.domain_show(domain).compose(mSchedulerTransformer);

        return mRepository.users_show(uid).compose(mSchedulerTransformer);
    }
}
