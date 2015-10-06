package it.jdark.android.animation.dynamicview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ListViewElementAnimationCustom extends ActionBarActivity {

    EditText textIn;
    Button buttonAdd;
    LinearLayout container;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_custom_layout);
        textIn = (EditText) findViewById(R.id.textin);
        buttonAdd = (Button) findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);

        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.listview_row_layout, null);
                TextView textOut = (TextView) addView.findViewById(R.id.textout);
                textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button) addView.findViewById(R.id.remove);
                buttonRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                });
                container.addView(addView, 0);
            }
        });

        LayoutTransition transition = new LayoutTransition();

        // From animator Resources
        Animator anim = AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip_on_vertical);
        transition.setAnimator(LayoutTransition.APPEARING, anim);
        transition.setStartDelay(LayoutTransition.APPEARING, 0);

        // Programmaticaly
        ObjectAnimator animator=ObjectAnimator.ofFloat(null, View.SCALE_X, 1f, 0f);
        transition.setAnimator(LayoutTransition.DISAPPEARING, animator);
        transition.setStartDelay(LayoutTransition.DISAPPEARING, 0);

        container.setLayoutTransition(transition);
        // This is for animate transaction of all the activity when it come visible
        //overridePendingTransition(R.anim.scale, R.anim.mix);
    }
}