package com.utildev.arch.architecturecomponents.presentation.fragment.github;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utildev.arch.architecturecomponents.R;
import com.utildev.arch.architecturecomponents.data.room.model.Github;
import com.utildev.arch.architecturecomponents.databinding.FragmentGithubBinding;
import com.utildev.arch.architecturecomponents.presentation.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;

public class GithubFragment extends BaseFragment {
    private FragmentGithubBinding binding;
    private GithubViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_github, container, false);
        viewModel = ViewModelProviders.of(this).get(GithubViewModel.class);
        binding.setViewModel(viewModel);
        init();
        return binding.getRoot();
    }

    private void init() {
        binding.fragGithubBtBack.setOnClickListener(view -> {
            EventBus.getDefault().post(new Github("Architecture Components", "retrofit2", "github.com"));
            clearStack();
        });

    }
}
