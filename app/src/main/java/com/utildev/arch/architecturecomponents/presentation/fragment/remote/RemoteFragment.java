package com.utildev.arch.architecturecomponents.presentation.fragment.remote;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utildev.arch.architecturecomponents.R;
import com.utildev.arch.architecturecomponents.databinding.FragmentRemoteBinding;
import com.utildev.arch.architecturecomponents.presentation.BaseFragment;

public class RemoteFragment extends BaseFragment {
    private FragmentRemoteBinding binding;
    private RemoteViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_remote, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(this).get(RemoteViewModel.class);
        binding.setViewModel(viewModel);
        return view;
    }
}
