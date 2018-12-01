package com.utildev.arch.architecturecomponents.presentation;

import android.databinding.BindingAdapter;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.utildev.arch.architecturecomponents.R;

public class ViewBindingAdapter {
    @BindingAdapter("show")
    public static void setAnimation(LinearLayout linearLayout, boolean show) {
        linearLayout.startAnimation(AnimationUtils.loadAnimation(linearLayout.getContext(),
                show ? R.anim.slide_enter_from_bottom : R.anim.slide_exit_to_bottom));
    }
}
