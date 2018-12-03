package com.utildev.arch.architecturecomponents.presentation.fragment.room;

import android.arch.lifecycle.Observer;
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
import com.utildev.arch.architecturecomponents.data.room.UserEntity;
import com.utildev.arch.architecturecomponents.databinding.FragmentRoomBinding;
import com.utildev.arch.architecturecomponents.presentation.BaseAdapter;
import com.utildev.arch.architecturecomponents.presentation.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class RoomFragment extends BaseFragment implements BaseAdapter.AdapterListener {
    private FragmentRoomBinding binding;
    private RoomViewModel viewModel;

    private List<UserEntity> userList;
    private BaseAdapter<UserEntity> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_room, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        binding.setViewModel(viewModel);
        init();
        registerLiveData();
        return view;
    }

    private void init() {
        userList = new ArrayList<>();
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        adapter = new BaseAdapter<>(binding.fragRoomIncludeList.viewListRvContent, layoutManager, R.layout.item_user);
        adapter.setAdapterListener(this);
        binding.setLayoutManager(layoutManager);
        binding.setAdapter(adapter);

        binding.fragRoomIncludeList.viewListSrLayout.setOnRefreshListener(() -> {
            userList.clear();
            adapter.set(userList);
            viewModel.getUserRoom();
            viewModel.showLoading(null);
            binding.fragRoomIncludeList.viewListSrLayout.setRefreshing(false);
        });

        viewModel.getUserRoom();
        viewModel.showLoading(null);
    }

    private void registerLiveData() {
        viewModel.getUserLiveData().observe(this, this::userEntityListener);
    }

    private void userEntityListener(List<UserEntity> userEntities) {
        if (userEntities != null) {
            if (userEntities.size() > 0) {
                adapter.setLoading(true);
                userList = userEntities;
                adapter.set(userList);
            } else {
                Toast.makeText(getContext(), "Empty!", Toast.LENGTH_SHORT).show();
            }
        }
        viewModel.dismissLoading(null);
    }

    @Override
    public void onItemClick(String value) {

    }

    @Override
    public boolean onItemLongClick(Object object) {
        return false;
    }

    @Override
    public void onLoadMore() {

    }
}
