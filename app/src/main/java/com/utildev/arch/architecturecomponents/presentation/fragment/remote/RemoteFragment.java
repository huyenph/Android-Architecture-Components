package com.utildev.arch.architecturecomponents.presentation.fragment.remote;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.utildev.arch.architecturecomponents.R;
import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestItemSE;
import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestUserSE;
import com.utildev.arch.architecturecomponents.databinding.FragmentRemoteBinding;
import com.utildev.arch.architecturecomponents.presentation.BaseAdapter;
import com.utildev.arch.architecturecomponents.presentation.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class RemoteFragment extends BaseFragment implements BaseAdapter.AdapterListener {
    private FragmentRemoteBinding binding;
    private RemoteViewModel viewModel;

    private List<RestItemSE> userList;
    private BaseAdapter<RestItemSE> adapter;

    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_remote, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(this).get(RemoteViewModel.class);
        binding.setViewModel(viewModel);
        init();
        registerLiveData();
        return view;
    }

    private void init() {
        userList = new ArrayList<>();
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        adapter = new BaseAdapter<>(binding.fragRemoteIncludeList.viewListRvContent, layoutManager, R.layout.item_user);
        adapter.setAdapterListener(this);
        binding.setLayoutManager(layoutManager);
        binding.setAdapter(adapter);

        binding.fragRemoteIncludeList.viewListSrLayout.setOnRefreshListener(() -> {
            userList.clear();
            page = 1;
            adapter.set(userList);
            viewModel.getUserSE("desc", "reputation", "stackoverflow", page);
            viewModel.showLoading(null);
            binding.fragRemoteIncludeList.viewListSrLayout.setRefreshing(false);
        });

        viewModel.getUserSE("desc", "reputation", "stackoverflow", page);
        viewModel.showLoading(null);
    }

    private void registerLiveData() {
        viewModel.getUserSELiveData().observe(this, this::liveDataListener);
    }

    private void liveDataListener(RestUserSE restUserSE) {
        if (restUserSE != null) {
            adapter.setLoading(true);
            userList.addAll(restUserSE.getItems());
            adapter.set(userList);
        } else {
            Toast.makeText(getContext(), "Connection error!", Toast.LENGTH_SHORT).show();
        }
        viewModel.dismissLoading(null);
    }

    @Override
    public void onItemClick(Object object) {
    }

    @Override
    public boolean onItemLongClick(Object object) {
        return false;
    }

    @Override
    public void onLoadMore() {
        viewModel.getUserSE("desc", "reputation", "stackoverflow", ++page);
    }
}
