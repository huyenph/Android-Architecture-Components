package com.utildev.arch.architecturecomponents.presentation.activity.main;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.utildev.arch.architecturecomponents.R;
import com.utildev.arch.architecturecomponents.data.room.model.Github;
import com.utildev.arch.architecturecomponents.databinding.ActivityMainBinding;
import com.utildev.arch.architecturecomponents.presentation.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Github github) {
        Toast.makeText(this, github.getTitle() + github.getLib() + github.getGithub(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
