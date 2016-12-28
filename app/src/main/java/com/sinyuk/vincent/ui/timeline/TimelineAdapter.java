package com.sinyuk.vincent.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.stream.StreamStringLoader;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.sinyuk.entities.Status;
import com.sinyuk.myutils.system.ScreenUtils;
import com.sinyuk.vincent.BR;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.databinding.ItemStatusBinding;
import com.sinyuk.vincent.ui.player.PlayerView;
import com.sinyuk.vincent.utils.glide.ExtensionUtils;
import com.sinyuk.vincent.utils.glide.GifDrawableByteTranscoder;
import com.sinyuk.vincent.utils.glide.StreamByteArrayResourceDecoder;
import com.sinyuk.vincent.utils.rv.BaseRvAdapter;
import com.sinyuk.vincent.utils.rv.BindingViewHolder;
import com.sinyuk.vincent.viewmodels.StatusModel;
import com.sinyuk.vincent.widgets.CheckableImageView;
import com.sinyuk.vincent.widgets.SquareImageView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import xyz.hanks.library.SmallBang;
import xyz.hanks.library.SmallBangListener;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class TimelineAdapter extends BaseRvAdapter<Status> {

    private final int spacing;
    private final int screenWidth;
    private final int thirdW;
    private final int halfW;

    private final GenericRequestBuilder<String, InputStream, byte[], GifDrawable> gifBuilder;
    private final DrawableRequestBuilder<String> jpgBuilder;
    private final SmallBang smallBang;

    public TimelineAdapter(Context context) {
        spacing = context.getResources().getDimensionPixelOffset(R.dimen.photo_cell_spacing);
        screenWidth = ScreenUtils.getScreenWidth(context);
        thirdW = (screenWidth) / 3;
        halfW = (screenWidth) / 2;

        gifBuilder = Glide
                .with(context)
                .using(new StreamStringLoader(context), InputStream.class)
                .from(String.class) // change this if you have a different model like a File and use StreamFileLoader above
                .as(byte[].class)
                .transcode(new GifDrawableByteTranscoder(), GifDrawable.class) // pass it on
                .diskCacheStrategy(DiskCacheStrategy.SOURCE) // cache original
                .decoder(new StreamByteArrayResourceDecoder())  // load original
                .sourceEncoder(new StreamEncoder())
                .placeholder(R.color.image_placeholder)
                .error(R.color.image_placeholder)
                .cacheDecoder(new FileToStreamDecoder<>(new StreamByteArrayResourceDecoder()));


        jpgBuilder = Glide
                .with(context)
                .from(String.class)
                .crossFade(300)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.color.image_placeholder)
                .error(R.color.image_placeholder);

        smallBang = SmallBang.attach2Window((Activity) context);
        smallBang.setColors(context.getResources().getIntArray(R.array.progress_colors));
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

        PhotoCellAdapter(List<Status.PicUrls> urls) {
            picUrls = urls;
        }

        @Override
        public PhotoCellAdapter.PhotoCell onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_cell, parent, false);
            return new PhotoCell(view);
        }

        @Override
        public void onBindViewHolder(PhotoCell holder, int position) {
            final String url = StatusModel.getPicUrl(
                    picUrls.get(position).getThumbnailPic(),
                    picUrls.size());
            if (ExtensionUtils.isGif(url)) {
                Log.d("PhotoCellAdapter", "GIF: " + url);
                gifBuilder.load(url).into(holder.imageView);
            } else {
                jpgBuilder.load(url).into(holder.imageView);
            }
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

    public void onClickThumb(View view, Status status, int position) {
        smallBang.bang(view, new SmallBangListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                ((CheckableImageView) view).setChecked(true);
            }
        });
    }


    public void onClickShare(View view, Status status, int position) {
    }

    public void onClickComment(View view, Status status, int position) {
        smallBang.bang(view, new SmallBangListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                ((CheckableImageView) view).setChecked(true);
            }
        });
    }

    public void onClickLike(View view, Status status, int position) {
        smallBang.bang(view, new SmallBangListener() {
            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationEnd() {
                if (position < mDataSet.size()) {
                    mDataSet.get(position).setFavorited(!mDataSet.get(position).isFavorited());
                }
                ((CheckableImageView) view).setChecked(true);
//                notifyItemChanged(position);
            }
        });
    }
}
