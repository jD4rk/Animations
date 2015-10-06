package it.jdark.android.animation.dynamicview.utils;

import android.content.res.Resources;

/**
 * Created by jdark on 20/03/15.
 */
public class DisplayUtils {
    private static int screenWidth = 0;
    private static int screenHeight = 0;

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
