package com.sinyuk.vincent.ui.home;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fivehundredpx.greedolayout.GreedoLayoutSizeCalculator;
import com.sinyuk.vincent.BR;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.utils.rv.BaseRvAdapter;
import com.sinyuk.vincent.utils.rv.BindingViewHolder;

/**
 * Created by sinyuk on 2016/12/22.
 */

public class PhotoAdapter extends BaseRvAdapter<Photo> implements GreedoLayoutSizeCalculator.SizeCalculatorDelegate {

    @Override
    protected long getMyItemId(int position) {
        return mDataSet.get(position).getId();
    }

    @Override
    protected BindingViewHolder onCreateMyItemViewHolder(ViewGroup parent, int viewType) {
        final ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_photo, parent, false);
        return new BindingViewHolder<>(binding);
    }

    @Override
    protected void onBindMyItemViewHolder(BindingViewHolder holder, int itemPositionInData) {
        holder.getBinding().setVariable(BR.data, mDataSet.get(itemPositionInData));
        holder.getBinding().setVariable(BR.presenter, this);
        holder.getBinding().setVariable(BR.position, itemPositionInData);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public double aspectRatioForIndex(int index) {
        if (index >= getDataItemCount()) return 1.0;

        return 1.f * mDataSet.get(itemPositionInData(index)).getWidth() /
                (1.f * mDataSet.get(itemPositionInData(index)).getHeight());
    }

    public void onItemClick(View view, Photo photo, int position) {
    }
}
