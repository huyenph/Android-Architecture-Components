package com.utildev.arch.architecturecomponents.presentation;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.utildev.arch.architecturecomponents.R;

public class ViewBindingAdapter {
    private static RequestOptions requestOptions = new RequestOptions().transforms(new CircleCrop());

    @BindingAdapter({"imageUrl", "progressBar"})
    public static void loadImage(ImageView imageView, String imageUrl, ProgressBar progressBar) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);
    }

    @BindingAdapter("show")
    public static void setAnimation(LinearLayout linearLayout, boolean show) {
        linearLayout.startAnimation(AnimationUtils.loadAnimation(linearLayout.getContext(),
                show ? R.anim.slide_enter_from_bottom : R.anim.slide_exit_to_bottom));
    }
}
