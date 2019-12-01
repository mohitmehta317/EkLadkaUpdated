package com.mohitmehta317.ekladka;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;

public class Thoughts extends Activity {

    TextView Thought_tv, Heading,MainHeading;
    ConstraintLayout Cl, SCl;
    Button BackButton, NextButton;
    int count = -1;
    GlobalDataClass objGlobal;
    ArrayList<Integer> Story_Id = new ArrayList<>(Arrays.asList(R.string.t1, R.string.t2, R.string.t3, R.string.t4, R.string.t5, R.string.t6, R.string.t7, R.string.t8, R.string.t9, R.string.t10, R.string.t11,R.string.t12,R.string.t13));

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoughts);
        GlobalDataClass.context = this;
        MainHeading = findViewById(R.id.mainHeading);
        BackButton = findViewById(R.id.backbutton);
        NextButton = findViewById(R.id.nextbutton);
        objGlobal = new GlobalDataClass();
        Thought_tv = findViewById(R.id.thoughts_tv);
        Heading = findViewById(R.id.heading);
        Thought_tv.setTypeface(objGlobal.setfont());
        Heading.setTypeface(objGlobal.setfont());
        BackButton.setTypeface(objGlobal.setfont());
        NextButton.setTypeface(objGlobal.setfont());
        MainHeading.setTypeface(objGlobal.setfont());
        MainHeading.setText(getResources().getString(R.string.heading));


        Cl = findViewById(R.id.animate_view);
        SCl = findViewById(R.id.scrollanimte);

        Cl.setOnTouchListener(new SwipeListener(Thoughts.this) {
            public void onSwipeRight() {
                if (count >= 0) {
                    rightanimation();
                } else {
                    Intent i = new Intent(Thoughts.this, SelectType.class);
                    startActivity(i);
                    Thoughts.this.finish();

                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                }
            }

            public void onSwipeLeft() {
                if (count < Story_Id.size()) {
                    leftanimation();
                }
            }

        });
        MainHeading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecttypeintent();
            }
        });
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < Story_Id.size()-1) {
                    leftanimation();
                }
                else {
                    Intent i = new Intent(Thoughts.this, SelectType.class);
                    startActivity(i);
                    Thoughts.this.finish();

                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                }
            }
        });
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    rightanimation();
                } else {
                    Intent i = new Intent(Thoughts.this, SelectType.class);
                    startActivity(i);
                    Thoughts.this.finish();
                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                }
            }
        });

        SCl.setOnTouchListener(new SwipeListener(Thoughts.this) {


            public void onSwipeRight() {
                if (count >= 0) {
                    rightanimation();
                } else {
                    Intent i = new Intent(Thoughts.this, SelectType.class);
                    startActivity(i);
                    Thoughts.this.finish();

                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
                }
            }

            public void onSwipeLeft() {
                if (count < Story_Id.size()) {
                    leftanimation();
                }
            }

        });
        leftanimation();

    }

    public void leftanimation() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);

        if (count < Story_Id.size()-1) {
            count++;
            Thought_tv.setText(getResources().getString(Story_Id.get(count)));
            Thought_tv.startAnimation(animation);

            Heading.setText(getResources().getString(R.string.heading2));

        }

        if (count == 0) {
            BackButton.setText(getResources().getString(R.string.back));
            NextButton.setText(getResources().getString(R.string.next));

        } else if (count == Story_Id.size()-1) {
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
        Heading.setText(getResources().getString(R.string.heading2));
        if (count == 0) {
            BackButton.setText(getResources().getString(R.string.back));
        } else {
            BackButton.setText(getResources().getString(R.string.previous));

        }

        NextButton.setText(getResources().getString(R.string.next));


    }
    private void selecttypeintent() {
        Intent i = new Intent(Thoughts.this,SelectType.class);
        startActivity(i);
        Thoughts.this.finish();
        overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
    }
    @Override
    public void onBackPressed() {

    }
}
