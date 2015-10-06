package it.jdark.android.animation.variousinactivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class MultiObject extends ActionBarActivity {

    private Button btn, btn2;
    private ImageView image, image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_object);

        btn = (Button) findViewById(R.id.startButton);
        btn2 = (Button) findViewById(R.id.startButton2);
        image = (ImageView) findViewById(R.id.image);
        image2 = (ImageView) findViewById(R.id.image2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim1 = ObjectAnimator.ofFloat(image, "alpha",
                        1.0f, 1.0f, 0.25f, 0.75f, 0.15f, 0.5f, 0.0f);
                ObjectAnimator anim2 = ObjectAnimator.ofFloat(image2, "alpha",
                        0.0f, 1.0f, 0.0f, 0.75f, 0.0f, 0.5f, 0.0f);
                AnimatorSet anim = new AnimatorSet();
                anim.playSequentially(anim1, anim2);
                anim.setDuration(3000);
//                anim.setInterpolator(new LinearInterpolator());
                anim.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim1 = ObjectAnimator.ofFloat(image, "alpha",
                        1.0f, 1.0f, 0.25f, 0.75f, 0.15f, 0.5f, 0.0f);
                ObjectAnimator anim2 = ObjectAnimator.ofFloat(image2, "alpha",
                        0.0f, 1.0f, 0.0f, 0.75f, 0.0f, 0.5f, 0.0f);
                AnimatorSet anim = new AnimatorSet();
                anim.playTogether(anim1, anim2);
                anim.setDuration(3000);
//                anim.setInterpolator(new LinearInterpolator());
                anim.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rotation, menu);
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
}
