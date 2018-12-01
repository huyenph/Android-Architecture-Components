package com.utildev.arch.architecturecomponents.presentation.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.utildev.arch.architecturecomponents.R;
import com.utildev.arch.architecturecomponents.presentation.BaseActivity;

public class MainActivity extends BaseActivity {
    private ActMainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(ActMainViewModel.class);
        viewModel.getUserSE("desc", "reputation", "stackoverflow", 1).observe(this, restUserSE -> {

        });
    }
}
