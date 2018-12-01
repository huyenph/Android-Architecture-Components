package com.utildev.arch.architecturecomponents.presentation.activity;

import android.os.Bundle;

import com.utildev.arch.architecturecomponents.R;
import com.utildev.arch.architecturecomponents.common.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
