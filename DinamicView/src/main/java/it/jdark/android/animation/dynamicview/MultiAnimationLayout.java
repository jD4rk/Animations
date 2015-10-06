package it.jdark.android.animation.dynamicview;

import android.animation.Animator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import it.jdark.android.animation.dynamicview.utils.DisplayUtils;


public class MultiAnimationLayout extends ActionBarActivity {

    Toolbar toolbar;
    FrameLayout container;
    Boolean introAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_animation_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        container = (FrameLayout) findViewById(R.id.container);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        introAnim= true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi_animation_layout, menu);
        if (introAnim) {
            introAnim = false;
            startAnimation();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startAnimation() {
        int tbH = toolbar.getHeight();
        toolbar.setTranslationY(-DisplayUtils.dpToPx(tbH));
        toolbar.animate().translationY(0).setDuration(500).setStartDelay(300)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.e("TAG", "Toolbar Animation END");
                        //startContentAnimation();
                        getFragmentManager().beginTransaction()
                                .setCustomAnimations(R.animator.slide_horizontal_left_in, R.animator.slide_horizontal_left_in)
                                .replace(R.id.container, new Frag(), "ciao")
                                .commit();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
    }


    public static class Frag extends Fragment {

        View rootView;
        LinearLayout overlay;
        int overlayHeight, overlayWidth;
        public Frag() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.e("FRAG", "onCreateView");
            rootView = inflater.inflate(R.layout.multi_animation_frament1, container, false);
            overlay= (LinearLayout) rootView.findViewById(R.id.overlayCity);
            ViewTreeObserver tree = overlay.getViewTreeObserver();
            tree.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    overlayHeight = overlay.getHeight();
                    overlayWidth = overlay.getWidth();
                }
            });
//            Log.e("GLOB", "++ " + rootView.getMeasuredHeight() + " ++ " + rootView.getMeasuredWidth());
//            Log.e("GLOB", "-- " + overlay.getMeasuredHeight() + " -- " + overlay.getMeasuredWidth());
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.e("FRAG", "onActivityCreated");
            Log.e("GLOB", "++ " + overlayHeight + " ++ " + overlayWidth);

            int overH = overlay.getHeight();
            overlay.setAlpha(0);
//            overlay.setTranslationY(DisplayUtils.dpToPx(overlayHeight));
            overlay.animate().alpha(1).setDuration(300).setStartDelay(2000);

        }

    }
}
