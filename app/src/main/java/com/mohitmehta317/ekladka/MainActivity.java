package com.mohitmehta317.ekladka;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    TextView Thought_tv, Heading;
    ConstraintLayout Cl, SCl;
    Button BackButton, NextButton;
    int count = -1;
    GlobalDataClass objGlobal;
    ArrayList<Integer> Story_Id = new ArrayList<>(Arrays.asList(R.string.p1, R.string.p2, R.string.p3, R.string.p4, R.string.p5, R.string.p6, R.string.p7, R.string.p8, R.string.p9, R.string.p10, R.string.p11));

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GlobalDataClass.context = this;
        BackButton = findViewById(R.id.backbutton);
        NextButton = findViewById(R.id.nextbutton);
        objGlobal = new GlobalDataClass();
        Thought_tv = findViewById(R.id.thoughts_tv);
        Heading = findViewById(R.id.heading);
        Thought_tv.setTypeface(objGlobal.setfont());
        Heading.setTypeface(objGlobal.setfont());
        BackButton.setTypeface(objGlobal.setfont());
        NextButton.setTypeface(objGlobal.setfont());


        Cl = findViewById(R.id.animate_view);
        SCl = findViewById(R.id.scrollanimte);
        Heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecttypeintent();
            }
        });

        Cl.setOnTouchListener(new SwipeListener(MainActivity.this) {
            public void onSwipeRight() {
                if (count >= 0) {
                    rightanimation();
                } else {
                    Intent i = new Intent(MainActivity.this, SelectType.class);
                    startActivity(i);
                    MainActivity.this.finish();

                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                }
            }

            public void onSwipeLeft() {
                if (count < Story_Id.size()) {
                    leftanimation();
                }
            }

        });
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(count+"_--------------");

                if (count < Story_Id.size()-1) {
                    leftanimation();
                }
                else {
                    selecttypeintent();
                }
            }
        });
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    rightanimation();
                } else {
                    Intent i = new Intent(MainActivity.this, SelectType.class);
                    startActivity(i);
                    MainActivity.this.finish();

                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                }
            }
        });

        SCl.setOnTouchListener(new SwipeListener(MainActivity.this) {


            public void onSwipeRight() {
                if (count >= 0) {
                    rightanimation();
                } else {
                    Intent i = new Intent(MainActivity.this, SelectType.class);
                    startActivity(i);
                    MainActivity.this.finish();

                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                }
            }

            public void onSwipeLeft() {
                if (count < Story_Id.size()-1) {
                    leftanimation();
                }
            }

        });
        leftanimation();

    }

    private void selecttypeintent() {
        Intent i = new Intent(MainActivity.this,SelectType.class);
        startActivity(i);
        MainActivity.this.finish();

        overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
    }

    public void leftanimation() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);

        if (count < Story_Id.size()-1) {
            count++;
            Thought_tv.setText(getResources().getString(Story_Id.get(count)));
            Thought_tv.startAnimation(animation);

            Heading.setText(getResources().getString(R.string.heading) + " ~ " + (count + 1));

        }

        if (count == 0) {
            BackButton.setText(getResources().getString(R.string.back));
            NextButton.setText(getResources().getString(R.string.next));

        } else if (count == 10) {
            NextButton.setText(getResources().getString(R.string.finish));
        } else {
            BackButton.setText(getResources().getString(R.string.previous));

        }

    }

    public void rightanimation() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);

        count--;
        Thought_tv.setText(getResources().getString(Story_Id.get(count)));
        Thought_tv.startAnimation(animation);
        Heading.setText(getResources().getString(R.string.heading) + " ~ " + (count + 1));
        if (count == 0) {
            BackButton.setText(getResources().getString(R.string.back));
        } else {
            BackButton.setText(getResources().getString(R.string.previous));

        }

        NextButton.setText(getResources().getString(R.string.next));


    }

    @Override
    public void onBackPressed() {

    }
}
