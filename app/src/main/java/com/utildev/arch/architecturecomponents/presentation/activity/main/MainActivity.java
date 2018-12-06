package com.utildev.arch.architecturecomponents.presentation.activity.main;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.utildev.arch.architecturecomponents.R;
import com.utildev.arch.architecturecomponents.databinding.ActivityMainBinding;
import com.utildev.arch.architecturecomponents.presentation.activity.BaseActivity;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private ActMainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(ActMainViewModel.class);
        binding.setViewModel(viewModel);
    }
}
