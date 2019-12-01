package com.mohitmehta317.ekladka;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SelectType extends Activity {

    Button Story, Thoughts, Contact, BackButton, NextButton;
    GlobalDataClass objGlobal;

    TextView MainHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
        Story = findViewById(R.id.button2);
        Thoughts = findViewById(R.id.button);
        Contact = findViewById(R.id.button3);
        GlobalDataClass.context = this;
        objGlobal = new GlobalDataClass();
        NextButton = findViewById(R.id.nextbutton);
        BackButton = findViewById(R.id.backbutton);
        BackButton.setTypeface(objGlobal.setfont());

        NextButton.setTypeface(objGlobal.setfont());
        Story.setTypeface(objGlobal.setfont());
        Thoughts.setTypeface(objGlobal.setfont());
        Contact.setTypeface(objGlobal.setfont());
        MainHeading = findViewById(R.id.mainHeading);
        MainHeading.setTypeface(objGlobal.setfont());
        MainHeading.setText(getResources().getString(R.string.heading));
        NextButton.setText(getResources().getString(R.string.next));
        BackButton.setText(getResources().getString(R.string.back));
        Story.setText(getResources().getString(R.string.story));
        Thoughts.setText(getResources().getString(R.string.heading2));
        Contact.setText(getResources().getString(R.string.contact));
        NextButton.setVisibility(View.GONE);


        Story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalDataClass.check = 1;
                buttonclick(Story, Thoughts, Contact);

            }
        });
        Thoughts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalDataClass.check = 2;
                buttonclick(Thoughts, Story, Contact);

            }
        });
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalDataClass.check = 3;
                buttonclick(Contact, Thoughts, Story);

            }
        });
        switch (GlobalDataClass.check) {
            case 1:
                Story.performClick();
                break;
            case 2:
                Thoughts.performClick();
                break;
            case 3:
                Contact.performClick();
                break;
        }
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = null;

                switch (GlobalDataClass.check) {
                    case 1:
                        i = new Intent(SelectType.this, MainActivity.class);
                        break;
                    case 2:
                        i = new Intent(SelectType.this, Thoughts.class);
                        break;
                    case 3:
                        i = new Intent(SelectType.this, ContactActivity.class);
                        break;


                }
                startActivity(i);
                SelectType.this.finish();

                overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
            }
        });
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backbutton();
            }
        });

    }

    public void buttonclick(Button clicked, Button unclicked, Button unclicked2) {
        clicked.setBackground(getResources().getDrawable(R.drawable.button_clicked));
        clicked.setTextColor(Color.parseColor("#000000"));
        unclicked.setBackground(getResources().getDrawable(R.drawable.button_unclicked));
        unclicked.setTextColor(Color.parseColor("#ffffff"));
        unclicked2.setBackground(getResources().getDrawable(R.drawable.button_unclicked));
        unclicked2.setTextColor(Color.parseColor("#ffffff"));
        NextButton.setVisibility(View.VISIBLE);

    }

    public void Backbutton() {
        Intent i = new Intent(SelectType.this, SelectLanguage.class);
        startActivity(i);
        SelectType.this.finish();

        overridePendingTransition(R.anim.slide_right, R.anim.slide_left);
    }

    @Override
    public void onBackPressed() {

    }
}
