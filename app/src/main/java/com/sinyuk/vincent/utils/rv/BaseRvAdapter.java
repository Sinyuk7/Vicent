package com.sinyuk.vincent.utils.rv;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sinyuk on 2016/11/10.
 */

public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {

    private static final String TAG = "BaseRvAdapter";
    protected List<T> mDataSet = new ArrayList<>();

    private static final int HEADER_VIEW_ID = Integer.MIN_VALUE;
    private static final int FOOTER_VIEW_ID = Integer.MAX_VALUE - 1;

    private static final int HEADER_VIEW_TYPE = Integer.MAX_VALUE;
    private static final int MAX_VIEW_TYPE = Integer.MAX_VALUE - 2;
    private static final int FOOTER_VIEW_TYPE = Integer.MAX_VALUE - 1;

    private ViewDataBinding headerBinding = null;
    private ViewDataBinding footerBinding = null;

    private boolean hasHeader() {
        return headerBinding != null && headerBinding.getRoot() != null;
    }


    private boolean hasFooter() {
        return footerBinding != null && footerBinding.getRoot() != null;
    }

    private boolean isHeader(int position) {
        return hasHeader() && position == 0;
    }

    private boolean isFooter(int position) {
        return hasFooter() && position == getDataItemCount() + (hasHeader() ? 1 : 0);
    }

    protected int itemPositionInData(int rvPosition) {
        return rvPosition - (hasHeader() ? 1 : 0);
    }

    protected int itemPositionInRV(int dataPosition) {
        return dataPosition + (hasHeader() ? 1 : 0);
    }

    public void addHeaderBinding(ViewDataBinding binding) {
        if (headerBinding == null) {
            headerBinding = binding;
            notifyItemInserted(0);
        } else {
            headerBinding = binding;
            notifyItemChanged(0);
        }
    }


    public void removeHeaderBinding() {
        if (headerBinding != null) {
            headerBinding = null;
            notifyDataSetChanged();
        }
    }


    public void addFooterBinding(ViewDataBinding binding) {
        if (footerBinding == null) {
            footerBinding = binding;
            notifyItemInserted(mDataSet.size());
        } else {
            footerBinding = binding;
            notifyItemChanged(mDataSet.size());
        }
    }

    public void removeFooterBinding() {
        if (footerBinding != null) {
            headerBinding = null;
            notifyItemRemoved(mDataSet.size());
        }
    }


    @Override
    public long getItemId(int position) {
        if (isFooter(position)) return FOOTER_VIEW_ID;
        if (isHeader(position)) return HEADER_VIEW_ID;

        return getMyItemId(position);
    }

    protected abstract long getMyItemId(int position);

    @Override
    public int getItemCount() {
        int itemCount = getDataItemCount();

        if (hasHeader()) {
            itemCount += 1;
        }
        if (hasFooter()) {
            itemCount += 1;
        }
        return itemCount;
    }

    public int getDataItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }


    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER_VIEW_TYPE) {
            return new BindingViewHolder<>(headerBinding);
        } else if (viewType == FOOTER_VIEW_TYPE) {
            return new BindingViewHolder<>(footerBinding);
        }
        return onCreateMyItemViewHolder(parent, viewType);
    }

    protected abstract BindingViewHolder onCreateMyItemViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        if (!isHeader(position) && !isFooter(position)) {
            onBindMyItemViewHolder(holder, itemPositionInData(position));
        }
    }

    protected abstract void onBindMyItemViewHolder(BindingViewHolder holder, int itemPositionInData);


//    @Override
//    public void onBindViewHolder(BindingViewHolder holder, int position, List<Object> payloads) {
//        if (!isHeader(position) && !isFooter(position)) {
//            onBindMyItemViewHolder(holder, itemPositionInData(position), payloads);
//        }
//    }
//
//    protected abstract void onBindMyItemViewHolder(BindingViewHolder holder, int i, List<Object> payloads);

    protected void notifyMyItemChanged(int position){

    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) {
            return HEADER_VIEW_TYPE;
        }
        if (isFooter(position)) {
            return FOOTER_VIEW_TYPE;
        }
        int dataItemType = getDataItemType(itemPositionInData(position));
        if (dataItemType > MAX_VIEW_TYPE) {
            throw new IllegalStateException("getDataItemType() must be less than " + MAX_VIEW_TYPE + ".");
        }
        return dataItemType;
    }

    /**
     * make sure your dataItemType < Integer.MAX_VALUE-1
     *
     * @param position item view position in rv
     * @return item viewType
     */
    protected int getDataItemType(int position) {
        return 0;
    }


    public void setData(List<T> data) {

        if (mDataSet.isEmpty()) {
            mDataSet.addAll(data);
            notifyItemRangeInserted(itemPositionInRV(0), data.size());
        } else {
            final int previousContentSize = mDataSet.size();
            mDataSet.clear();
            mDataSet.addAll(data);
            notifyItemRangeRemoved(itemPositionInRV(0), previousContentSize);
            notifyItemRangeInserted(itemPositionInRV(0), data.size());
//            notifyDataSetChanged();
        }
    }


    public void appendData(List<T> data) {
        final int start = mDataSet.size();
        mDataSet.addAll(data);
        notifyItemRangeInserted(itemPositionInRV(start), data.size());
    }

}
