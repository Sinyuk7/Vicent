package com.sinyuk.vincent.ui.timeline;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sinyuk.entities.Status;
import com.sinyuk.myutils.system.ScreenUtils;
import com.sinyuk.vincent.BR;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.databinding.ItemStatusBinding;
import com.sinyuk.vincent.ui.player.PlayerView;
import com.sinyuk.vincent.utils.rv.BaseRvAdapter;
import com.sinyuk.vincent.utils.rv.BindingViewHolder;
import com.sinyuk.vincent.viewmodels.StatusModel;
import com.sinyuk.vincent.widgets.SquareImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class TimelineAdapter extends BaseRvAdapter<Status> {

    private final int spacing;
    private final int screenWidth;
    private final int thirdW;
    private final int halfW;


    public TimelineAdapter(Context context) {
        spacing = context.getResources().getDimensionPixelOffset(R.dimen.photo_cell_spacing);
        screenWidth = ScreenUtils.getScreenWidth(context);
        thirdW = (screenWidth) / 3;
        halfW = (screenWidth) / 2;
    }

    @Override
    protected long getMyItemId(int position) {
        if (mDataSet.get(position) == null)
            return RecyclerView.NO_ID;
        return mDataSet.get(position).getId();
    }

    @Override
    protected BindingViewHolder onCreateMyItemViewHolder(ViewGroup parent, int viewType) {
        final ItemStatusBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_status, parent, false);
        return new BindingViewHolder<>(binding);
    }

    @Override
    protected void onBindMyItemViewHolder(BindingViewHolder holder, int itemPositionInData, List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindMyItemViewHolder(holder, itemPositionInData);
        } else {

        }
    }

    @Override
    protected void onBindMyItemViewHolder(BindingViewHolder holder, int itemPositionInData) {
        final Status data = mDataSet.get(itemPositionInData);

        holder.getBinding().setVariable(BR.data, data);

        holder.getBinding().setVariable(BR.presenter, this);

        holder.getBinding().setVariable(BR.position, itemPositionInData);

        if (data.getPicUrls() != null && !data.getPicUrls().isEmpty()) {
            int spanCount = 1;
            switch (data.getPicUrls().size()) {
                case 1:
                    spanCount = 1;
                    break;
                case 2:
                case 8:
                case 4:
                    spanCount = 2;
                    break;
                case 5:
                case 7:
                case 3:
                case 9:
                case 6:
                    spanCount = 3;
                    break;

            }
            final GridLayoutManager layoutManager = new GridLayoutManager(holder.getBinding().getRoot().getContext(), spanCount) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }

                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            layoutManager.setAutoMeasureEnabled(true);

            ((ItemStatusBinding) holder.getBinding()).gridView.setLayoutManager(layoutManager);

            ((ItemStatusBinding) holder.getBinding()).gridView.setHasFixedSize(true);

            ((ItemStatusBinding) holder.getBinding()).gridView.setAdapter(new PhotoCellAdapter(data.getPicUrls()));
        }


        if (data.getRetweetedStatus() != null && data.getRetweetedStatus().getPicUrls() != null && !data.getRetweetedStatus().getPicUrls().isEmpty()) {

            int spanCount = 1;
            switch (data.getRetweetedStatus().getPicUrls().size()) {
                case 1:
                    spanCount = 1;
                    break;
                case 2:
                case 8:
                case 4:
                    spanCount = 2;
                    break;
                case 5:
                case 7:
                case 3:
                case 9:
                case 6:
                    spanCount = 3;
                    break;

            }
            final GridLayoutManager layoutManager = new GridLayoutManager(holder.getBinding().getRoot().getContext(), spanCount) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }

                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            layoutManager.setAutoMeasureEnabled(true);

            ((ItemStatusBinding) holder.getBinding()).retweetedPhotos.setLayoutManager(layoutManager);

            ((ItemStatusBinding) holder.getBinding()).retweetedPhotos.setHasFixedSize(true);

            ((ItemStatusBinding) holder.getBinding()).retweetedPhotos.setAdapter(new PhotoCellAdapter(data.getRetweetedStatus().getPicUrls()));
        }


        holder.getBinding().executePendingBindings();
    }


    public void onClickAvatar(View view, long uid, int position) {
        PlayerView.start(view.getContext(), uid);
    }

    private class PhotoCellAdapter extends RecyclerView.Adapter<PhotoCellAdapter.PhotoCell> {

        private List<Status.PicUrls> picUrls = new ArrayList<>();

        PhotoCellAdapter(List<Status.PicUrls> picUrls) {
            this.picUrls = picUrls;
        }

        @Override
        public PhotoCellAdapter.PhotoCell onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_cell, parent, false);
            return new PhotoCell(view);
        }

        @Override
        public void onBindViewHolder(PhotoCell holder, int position) {

            Glide.with(holder.imageView.getContext())
                    .load(StatusModel.getPicUrl(
                            picUrls.get(position).getThumbnailPic(),
                            picUrls.size()))
                    .crossFade(300)
                    .into(holder.imageView);
        }


        @Override
        public int getItemCount() {
            return picUrls.size();
        }

        class PhotoCell extends RecyclerView.ViewHolder {

            private SquareImageView imageView;

            PhotoCell(View itemView) {
                super(itemView);
                imageView = (SquareImageView) itemView.findViewById(R.id.photo);

                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return false;
                    }
                });
            }
        }

    }
}
