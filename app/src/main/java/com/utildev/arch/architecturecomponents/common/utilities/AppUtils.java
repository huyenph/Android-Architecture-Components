package com.utildev.arch.architecturecomponents.common.utilities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class AppUtils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = null;
        if (manager != null) {
            info = manager.getActiveNetworkInfo();
        }
        return info != null && info.isConnectedOrConnecting();
    }

    @SuppressLint("ClickableViewAccessibility")
    public static void setupKeyboard(View view, Activity activity, boolean clearFocus) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener((v, event) -> {
                if (view.getTag() != null) {
                    return false;
                }
                if (clearFocus) {
                    view.requestFocus();
                }
                hideSoftKeyboard(activity);
                return false;
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupKeyboard(innerView, activity, clearFocus);
            }
        }
    }

    private static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager manager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            View view = activity.getCurrentFocus();
            if (view != null && manager != null) {
                manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                if (view instanceof EditText) {
                    EditText editText = (EditText) view;
                    clearFocusEditText(new EditText[]{editText});
                }
            }
        } catch (Exception ignored) {

        }
    }

    private static void clearFocusEditText(EditText[] editTexts) {
        for (EditText editText : editTexts) {
            editText.clearFocus();
        }
    }
}
