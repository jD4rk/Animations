package it.jdark.android.animation.dynamicview.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import it.jdark.android.animation.dynamicview.R;

/**
 * Created by jdark on 22/03/15.
 */
public class ViewUtils {
    public static void addElementToList(Context ctx, LinearLayout container, int resId) {
        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(resId, null);
        container.addView(addView, 0);
    }
}
