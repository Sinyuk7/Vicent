package com.sinyuk.vincent.ui.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.android.annotations.NonNull;
import com.sinyuk.entities.Status;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/26.
 */

public class StatusDiffCallback extends DiffUtil.Callback {
    private final List<Status> mOldList;
    private final List<Status> mNewList;

    public StatusDiffCallback(@NonNull List<Status> mOldList, @NonNull List<Status> mNewList) {
        this.mOldList = mOldList;
        this.mNewList = mNewList;
    }

    @Override
    public int getOldListSize() {
        return mOldList != null ? mOldList.size() : 0;

    }

    @Override
    public int getNewListSize() {
        return mNewList != null ? mNewList.size() : 0;

    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mNewList.get(newItemPosition).getId() == mOldList.get(oldItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mNewList.get(newItemPosition).equals(mOldList.get(oldItemPosition));
    }

    public static final String KEY_FAVORITED = "FAVORITED";

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Status newItem = mNewList.get(newItemPosition);
        Status oldItem = mOldList.get(oldItemPosition);
        Bundle diffBundle = new Bundle();

        if (newItem.isFavorited() != (oldItem.isFavorited())) {
            diffBundle.putBoolean(KEY_FAVORITED, newItem.isFavorited());
        }

        if (diffBundle.size() == 0) return null;
        return diffBundle;
    }
}
