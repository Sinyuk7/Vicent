package com.sinyuk.vincent.ui.timeline;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinyuk.entities.Status;
import com.sinyuk.myutils.ConvertUtils;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.base.BaseFragment;
import com.sinyuk.vincent.databinding.LayoutStatesBinding;
import com.sinyuk.vincent.utils.rv.GridSpacingItemDecoration;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class TimelineView extends BaseFragment implements TimelineContract.View {
    private TimelineContract.Presenter presenter;
    private TimelineAdapter adapter;

    @Override
    public void setPresenter(TimelineContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private LayoutStatesBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_states, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSwipeRefreshLayout();
        initList();
        presenter.refresh();

    }

    private void initSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setColorSchemeColors(getResources().getIntArray(R.array.progress_colors));
        binding.swipeRefreshLayout.setOnRefreshListener(() -> presenter.refresh());
    }

    private void initList() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setAutoMeasureEnabled(true);

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        binding.recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, ConvertUtils.dp2px(getContext(), 18), false));

        adapter = new TimelineAdapter(getContext());
        adapter.setHasStableIds(true);
        binding.recyclerView.setAdapter(adapter);

        binding.recyclerView.addOnScrollListener(getLoadMoreListener());
    }


    public RecyclerView.OnScrollListener getLoadMoreListener() {
        return new RecyclerView.OnScrollListener() {
            static final int PRELOAD_THRESHOLD = 1;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                final LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                boolean isBottom =
                        layoutManager.findLastCompletelyVisibleItemPosition() >= recyclerView.getAdapter().getItemCount() - PRELOAD_THRESHOLD;
                if (isBottom) {
                    presenter.loadMore();
                }
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void setData(List<Status> photos, boolean clear) {
        adapter.setData(photos, clear);
    }

    @Override
    public void startRefreshing() {
        binding.viewAnimator.setDisplayedChildId(R.id.swipeRefreshLayout);
        binding.swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void stopRefreshing() {
        binding.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void startLoading() {
        binding.progressbar.setVisibility(View.VISIBLE);
        binding.progressbar.progressiveStart();
    }

    @Override
    public void stopLoading() {
        binding.progressbar.progressiveStop();
        binding.progressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(Throwable throwable) {
        binding.setErrorMessage(throwable.getMessage());
        binding.viewAnimator.setDisplayedChildId(R.id.errorLayout);
    }

    @Override
    public void showNoMore() {

    }

    @Override
    public void showEmpty() {
        binding.viewAnimator.setDisplayedChildId(R.id.emptyLayout);
    }
}
